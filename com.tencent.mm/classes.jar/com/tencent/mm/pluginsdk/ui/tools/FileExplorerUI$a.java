package com.tencent.mm.pluginsdk.ui.tools;

import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class FileExplorerUI$a
  extends BaseAdapter
{
  String fVd;
  private File wep;
  private File weq;
  private File[] wer;
  
  private FileExplorerUI$a(FileExplorerUI paramFileExplorerUI) {}
  
  private void a(File[] paramArrayOfFile)
  {
    AppMethodBeat.i(105850);
    if ((paramArrayOfFile == null) || (paramArrayOfFile.length == 0))
    {
      AppMethodBeat.o(105850);
      return;
    }
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    int j = paramArrayOfFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile = paramArrayOfFile[i];
      FileExplorerUI.b localb = new FileExplorerUI.b(this.wem, (byte)0);
      localb.file = localFile;
      localb.wet = g.wq(localFile.getName()).toUpperCase();
      if (localFile.isDirectory()) {
        ((List)localObject2).add(localb);
      }
      for (;;)
      {
        i += 1;
        break;
        ((List)localObject1).add(localb);
      }
    }
    Collections.sort((List)localObject2, new FileExplorerUI.a.2(this));
    Collections.sort((List)localObject1, new FileExplorerUI.a.3(this));
    localObject2 = ((List)localObject2).iterator();
    i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      paramArrayOfFile[i] = ((FileExplorerUI.b)((Iterator)localObject2).next()).file;
      i += 1;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      paramArrayOfFile[i] = ((FileExplorerUI.b)((Iterator)localObject1).next()).file;
      i += 1;
    }
    AppMethodBeat.o(105850);
  }
  
  public final void g(File paramFile1, File paramFile2)
  {
    AppMethodBeat.i(105847);
    this.wep = paramFile1;
    if (paramFile2.getAbsolutePath().equalsIgnoreCase(this.fVd)) {
      this.wep = null;
    }
    this.weq = paramFile2;
    if ((this.weq.canRead()) && (this.weq.isDirectory()))
    {
      this.wer = this.weq.listFiles(new FileExplorerUI.a.1(this));
      if (this.wer == null) {
        this.wer = new File[0];
      }
      if (this.wer.length > 0)
      {
        a(this.wer);
        AppMethodBeat.o(105847);
      }
    }
    else
    {
      this.wer = new File[0];
    }
    AppMethodBeat.o(105847);
  }
  
  public final int getCount()
  {
    int i = 0;
    if (this.wer == null) {
      return 0;
    }
    int j = this.wer.length;
    if (this.wep != null) {
      i = 1;
    }
    return i + j;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(105848);
    if ((this.wep != null) && (paramInt == 0))
    {
      localObject = this.wep;
      AppMethodBeat.o(105848);
      return localObject;
    }
    ab.d("FileExplorer", "pos:" + paramInt + ", subFile length:" + this.wer.length);
    Object localObject = this.wer;
    if (this.wep == null) {}
    for (;;)
    {
      localObject = localObject[paramInt];
      AppMethodBeat.o(105848);
      return localObject;
      paramInt -= 1;
    }
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(105849);
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = View.inflate(this.wem, 2130970064, null);
      paramView = new FileExplorerUI.c(this.wem, (byte)0);
      paramView.ivs = ((ImageView)paramViewGroup.findViewById(2131825863));
      paramView.gzk = ((TextView)paramViewGroup.findViewById(2131824017));
      paramView.weu = ((TextView)paramViewGroup.findViewById(2131825875));
      paramViewGroup.setTag(paramView);
    }
    Object localObject = (FileExplorerUI.c)paramViewGroup.getTag();
    paramView = (File)getItem(paramInt);
    if (paramView == this.wep)
    {
      ((FileExplorerUI.c)localObject).gzk.setText(paramView.getName());
      ((FileExplorerUI.c)localObject).ivs.setImageResource(2130840018);
      ((FileExplorerUI.c)localObject).weu.setVisibility(0);
      AppMethodBeat.o(105849);
      return paramViewGroup;
    }
    ((FileExplorerUI.c)localObject).ivs.setImageResource(FileExplorerUI.V(paramView));
    ((FileExplorerUI.c)localObject).gzk.setText(paramView.getName());
    localObject = ((FileExplorerUI.c)localObject).weu;
    StringBuilder localStringBuilder = new StringBuilder().append(DateFormat.format("yyyy-MM-dd hh:mm:ss", paramView.lastModified()).toString());
    if (paramView.isDirectory()) {}
    for (paramView = "";; paramView = "  " + bo.hk(paramView.length()))
    {
      ((TextView)localObject).setText(paramView);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI.a
 * JD-Core Version:    0.7.0.1
 */