package com.tencent.mm.plugin.story.api;

import android.content.Context;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.protocal.protobuf.dkd;
import java.util.List;

public abstract interface e
  extends d
{
  public abstract void addStoryStatusNotifyListener(m paramm);
  
  public abstract boolean canPostStory();
  
  public abstract void checkPost();
  
  public abstract boolean checkReportFromChatting(int paramInt, String paramString);
  
  public abstract void enterGallery(List<String> paramList);
  
  public abstract String getAccStoryCachePath();
  
  public abstract String getAccStoryPath();
  
  public abstract String getAccStoryTmpPath();
  
  public abstract l.c getContactFetcher();
  
  public abstract b getFavourUserChecker();
  
  public abstract f getStoryBasicConfig();
  
  public abstract j getStoryNewFeatureConfig();
  
  public abstract l getStoryStateFetcher(String paramString);
  
  public abstract n getStoryUIFactory();
  
  public abstract dkd getStoryUserInfo();
  
  public abstract boolean hasNewStory(String paramString);
  
  public abstract boolean isShowStoryCheck();
  
  public abstract boolean isStoryExist(String paramString);
  
  public abstract boolean isStoryUnread(String paramString);
  
  public abstract void loadStory(String paramString1, String paramString2);
  
  public abstract boolean preLoadVideoViewMgr(String paramString);
  
  public abstract void preloadForSnsUser(String paramString, boolean paramBoolean);
  
  public abstract void reportWaitPlayList(List<String> paramList, long paramLong);
  
  public abstract boolean showStoryEntranceDialog(Context paramContext, String paramString, int paramInt);
  
  public abstract void startStoryCaptureForResult(Context paramContext, int paramInt1, long paramLong, int paramInt2);
  
  public abstract void updateStoryUserInfo(String paramString, dkd paramdkd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.e
 * JD-Core Version:    0.7.0.1
 */