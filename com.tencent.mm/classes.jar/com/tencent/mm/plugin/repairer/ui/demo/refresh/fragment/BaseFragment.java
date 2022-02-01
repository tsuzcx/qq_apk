package com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.tencent.mm.view.refreshLayout.WxRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/BaseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "datas", "", "", "getDatas", "()Ljava/util/List;", "refreshLayout", "Lcom/tencent/mm/view/refreshLayout/WxRefreshLayout;", "getRefreshLayout", "()Lcom/tencent/mm/view/refreshLayout/WxRefreshLayout;", "setRefreshLayout", "(Lcom/tencent/mm/view/refreshLayout/WxRefreshLayout;)V", "down", "", "count", "", "getLayoutId", "initData", "initView", "view", "Landroid/view/View;", "notifyDataChanged", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "up", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseFragment
  extends Fragment
{
  public WxRefreshLayout EMN;
  final List<String> lMl = (List)new ArrayList();
  
  public abstract void aNi();
  
  public final void ahr(int paramInt)
  {
    this.lMl.clear();
    int i = 0;
    if (paramInt >= 0) {}
    for (;;)
    {
      this.lMl.add(s.X("测试数据", Integer.valueOf(i)));
      if (i == paramInt)
      {
        cPy();
        return;
      }
      i += 1;
    }
  }
  
  public final void b(WxRefreshLayout paramWxRefreshLayout)
  {
    s.u(paramWxRefreshLayout, "<set-?>");
    this.EMN = paramWxRefreshLayout;
  }
  
  public void cPy() {}
  
  public final WxRefreshLayout gNo()
  {
    WxRefreshLayout localWxRefreshLayout = this.EMN;
    if (localWxRefreshLayout != null) {
      return localWxRefreshLayout;
    }
    s.bIx("refreshLayout");
    return null;
  }
  
  public abstract int getLayoutId();
  
  public abstract void iS(View paramView);
  
  public final void nO()
  {
    int i = this.lMl.size();
    int k = i + 10;
    if (i < k) {}
    for (;;)
    {
      int j = i + 1;
      this.lMl.add(s.X("测试数据", Integer.valueOf(i)));
      if (j >= k)
      {
        cPy();
        return;
      }
      i = j;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    s.u(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(getLayoutId(), null);
    s.s(paramLayoutInflater, "view");
    iS(paramLayoutInflater);
    aNi();
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment.BaseFragment
 * JD-Core Version:    0.7.0.1
 */