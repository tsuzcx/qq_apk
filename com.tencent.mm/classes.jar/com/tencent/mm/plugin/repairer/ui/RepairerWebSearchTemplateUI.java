package com.tencent.mm.plugin.repairer.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.au;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/RepairerWebSearchTemplateUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "getLayoutId", "", "getNameByType", "", "type", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerWebSearchTemplateUI
  extends BaseRepairerUI
{
  private static final boolean a(RepairerWebSearchTemplateUI paramRepairerWebSearchTemplateUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(277820);
    s.u(paramRepairerWebSearchTemplateUI, "this$0");
    paramRepairerWebSearchTemplateUI.finish();
    AppMethodBeat.o(277820);
    return false;
  }
  
  public final int getLayoutId()
  {
    return b.d.Owf;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(277836);
    super.onCreate(paramBundle);
    setBackBtn(new RepairerWebSearchTemplateUI..ExternalSyntheticLambda0(this));
    TextView localTextView = (TextView)findViewById(b.c.OuB);
    if (localTextView != null)
    {
      List localList = (List)new ArrayList();
      int i = 0;
      if (i < 11)
      {
        int j = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }[i];
        paramBundle = aj.asW(j);
        int k = paramBundle.bIH();
        paramBundle.iqn();
        int m = paramBundle.bIG();
        StringBuilder localStringBuilder = new StringBuilder("type:").append(j).append(" name:");
        switch (j)
        {
        default: 
          paramBundle = "未知";
        }
        for (;;)
        {
          localList.add(paramBundle + " assertVersion:" + k + " currentVersion:" + m);
          i += 1;
          break;
          paramBundle = "搜一搜";
          continue;
          paramBundle = "看一看";
          continue;
          paramBundle = "航班号";
          continue;
          paramBundle = "小程序搜索";
          continue;
          paramBundle = "扫物";
          continue;
          paramBundle = "Pardus";
          continue;
          paramBundle = "Tag搜索";
          continue;
          paramBundle = "微信素材";
          continue;
          paramBundle = "图像识别";
          continue;
          paramBundle = "每日一看";
          continue;
          paramBundle = "表情搜索";
        }
      }
      localTextView.setText((CharSequence)p.a((Iterable)localList, (CharSequence)"\n", null, null, 0, null, null, 62));
    }
    AppMethodBeat.o(277836);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerWebSearchTemplateUI
 * JD-Core Version:    0.7.0.1
 */