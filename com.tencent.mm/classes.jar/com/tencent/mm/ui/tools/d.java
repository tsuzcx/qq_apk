package com.tencent.mm.ui.tools;

import android.view.View.OnFocusChangeListener;
import android.widget.TextView.OnEditorActionListener;
import java.util.ArrayList;

public abstract interface d
{
  public abstract void CG(boolean paramBoolean);
  
  public abstract void CH(boolean paramBoolean);
  
  public abstract void gXo();
  
  public abstract boolean gXp();
  
  public abstract boolean gXq();
  
  public abstract String getSearchContent();
  
  public abstract void setAutoMatchKeywords(boolean paramBoolean);
  
  public abstract void setBackClickCallback(ActionBarSearchView.a parama);
  
  public abstract void setCallBack(ActionBarSearchView.b paramb);
  
  public abstract void setEditTextEnabled(boolean paramBoolean);
  
  public abstract void setFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener);
  
  public abstract void setHint(CharSequence paramCharSequence);
  
  public abstract void setKeywords(ArrayList<String> paramArrayList);
  
  public abstract void setNotRealCallBack(SearchViewNotRealTimeHelper.a parama);
  
  public abstract void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener);
  
  public abstract void setSearchContent(String paramString);
  
  public abstract void setSearchTipIcon(int paramInt);
  
  public abstract void setSelectedTag(String paramString);
  
  public abstract void setStatusBtnEnabled(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.d
 * JD-Core Version:    0.7.0.1
 */