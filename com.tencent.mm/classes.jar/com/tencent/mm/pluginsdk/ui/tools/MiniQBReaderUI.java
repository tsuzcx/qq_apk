package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.xweb.d.a;

@com.tencent.mm.ui.base.a(3)
public class MiniQBReaderUI
  extends MMActivity
{
  private String elt;
  private String fileName;
  private String filePath;
  private String token;
  
  public MiniQBReaderUI()
  {
    AppMethodBeat.i(28171);
    this.filePath = "";
    this.elt = "";
    this.fileName = "";
    this.token = Integer.toString(hashCode());
    AppMethodBeat.o(28171);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28172);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.MiniQBReaderUI", "onCreate");
    this.filePath = getIntent().getStringExtra("file_path");
    this.elt = getIntent().getStringExtra("file_ext");
    try
    {
      int j = this.filePath.lastIndexOf('/') + 1;
      if (j < 0) {
        break label175;
      }
      i = j;
      if (j != this.filePath.length()) {}
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ab.e("MicroMsg.MiniQBReaderUI", "get file name error " + paramBundle.getMessage());
        this.fileName = " ";
        continue;
        int i = 0;
      }
    }
    this.fileName = this.filePath.substring(i, this.filePath.length());
    com.tencent.mm.cn.a.a(this, this.filePath, this.fileName, this.elt, this.token, d.a.BDa, new MiniQBReaderUI.1(this), new ValueCallback() {});
    AppMethodBeat.o(28172);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28174);
    ab.i("MicroMsg.MiniQBReaderUI", "onDestroy");
    com.tencent.mm.cn.a.M(this, this.token, this.filePath);
    super.onDestroy();
    AppMethodBeat.o(28174);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(28173);
    super.onNewIntent(paramIntent);
    ab.i("MicroMsg.MiniQBReaderUI", "onNewIntent");
    AppMethodBeat.o(28173);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI
 * JD-Core Version:    0.7.0.1
 */