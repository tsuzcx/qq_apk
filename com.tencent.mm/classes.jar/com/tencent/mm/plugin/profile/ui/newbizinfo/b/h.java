package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fo;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class h
  extends fo
{
  public static IAutoDBItem.MAutoDBInfo iBg;
  
  static
  {
    AppMethodBeat.i(27585);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[17];
    localMAutoDBInfo.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "username";
    localMAutoDBInfo.columns[1] = "originalArticleCount";
    localMAutoDBInfo.colsMap.put("originalArticleCount", "INTEGER default '1' ");
    localStringBuilder.append(" originalArticleCount INTEGER default '1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "friendSubscribeCount";
    localMAutoDBInfo.colsMap.put("friendSubscribeCount", "INTEGER default '1' ");
    localStringBuilder.append(" friendSubscribeCount INTEGER default '1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "allArticleWording";
    localMAutoDBInfo.colsMap.put("allArticleWording", "TEXT");
    localStringBuilder.append(" allArticleWording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "historyArticlesUrl";
    localMAutoDBInfo.colsMap.put("historyArticlesUrl", "TEXT");
    localStringBuilder.append(" historyArticlesUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "userRole";
    localMAutoDBInfo.colsMap.put("userRole", "INTEGER default '1' ");
    localStringBuilder.append(" userRole INTEGER default '1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "banReason";
    localMAutoDBInfo.colsMap.put("banReason", "TEXT");
    localStringBuilder.append(" banReason TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "showRecommendArticle";
    localMAutoDBInfo.colsMap.put("showRecommendArticle", "INTEGER default '0' ");
    localStringBuilder.append(" showRecommendArticle INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "showService";
    localMAutoDBInfo.colsMap.put("showService", "INTEGER default '0' ");
    localStringBuilder.append(" showService INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "messageListStr";
    localMAutoDBInfo.colsMap.put("messageListStr", "TEXT");
    localStringBuilder.append(" messageListStr TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "serviceInfoListStr";
    localMAutoDBInfo.colsMap.put("serviceInfoListStr", "TEXT");
    localStringBuilder.append(" serviceInfoListStr TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "bizAccountListStr";
    localMAutoDBInfo.colsMap.put("bizAccountListStr", "TEXT");
    localStringBuilder.append(" bizAccountListStr TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "cacheTime";
    localMAutoDBInfo.colsMap.put("cacheTime", "LONG default '0' ");
    localStringBuilder.append(" cacheTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "decryptUserName";
    localMAutoDBInfo.colsMap.put("decryptUserName", "TEXT default '' ");
    localStringBuilder.append(" decryptUserName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "hiddenAvatar";
    localMAutoDBInfo.colsMap.put("hiddenAvatar", "INTEGER default '0' ");
    localStringBuilder.append(" hiddenAvatar INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "hiddenButtonBeforeFocus";
    localMAutoDBInfo.colsMap.put("hiddenButtonBeforeFocus", "INTEGER default '0' ");
    localStringBuilder.append(" hiddenButtonBeforeFocus INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "newBanReason";
    localMAutoDBInfo.colsMap.put("newBanReason", "TEXT");
    localStringBuilder.append(" newBanReason TEXT");
    localMAutoDBInfo.columns[17] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    iBg = localMAutoDBInfo;
    AppMethodBeat.o(27585);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return iBg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.h
 * JD-Core Version:    0.7.0.1
 */