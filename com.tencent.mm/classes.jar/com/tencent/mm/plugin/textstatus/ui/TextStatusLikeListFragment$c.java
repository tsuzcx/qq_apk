package com.tencent.mm.plugin.textstatus.ui;

import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListFragment$DataLoader;", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "hasMoreData", "", "loadNextPage", "", "release", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
abstract class TextStatusLikeListFragment$c
{
  public static final a Tzy = new a((byte)0);
  private WxRecyclerAdapter<a> ALE;
  
  public TextStatusLikeListFragment$c(WxRecyclerAdapter<a> paramWxRecyclerAdapter)
  {
    this.ALE = paramWxRecyclerAdapter;
  }
  
  public final WxRecyclerAdapter<a> getAdapter()
  {
    return this.ALE;
  }
  
  public abstract void gir();
  
  public abstract boolean hJS();
  
  public abstract void release();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListFragment$DataLoader$Companion;", "", "()V", "NUM_PER_PAGE", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListFragment.c
 * JD-Core Version:    0.7.0.1
 */