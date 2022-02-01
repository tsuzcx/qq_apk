package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ew;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class h
  extends ew
{
  public static c.a hlR;
  
  static
  {
    AppMethodBeat.i(27585);
    c.a locala = new c.a();
    locala.GvF = new Field[17];
    locala.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.GvH.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "username";
    locala.columns[1] = "originalArticleCount";
    locala.GvH.put("originalArticleCount", "INTEGER default '1' ");
    localStringBuilder.append(" originalArticleCount INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "friendSubscribeCount";
    locala.GvH.put("friendSubscribeCount", "INTEGER default '1' ");
    localStringBuilder.append(" friendSubscribeCount INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "allArticleWording";
    locala.GvH.put("allArticleWording", "TEXT");
    localStringBuilder.append(" allArticleWording TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "historyArticlesUrl";
    locala.GvH.put("historyArticlesUrl", "TEXT");
    localStringBuilder.append(" historyArticlesUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "userRole";
    locala.GvH.put("userRole", "INTEGER default '1' ");
    localStringBuilder.append(" userRole INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "banReason";
    locala.GvH.put("banReason", "TEXT");
    localStringBuilder.append(" banReason TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "showRecommendArticle";
    locala.GvH.put("showRecommendArticle", "INTEGER default '0' ");
    localStringBuilder.append(" showRecommendArticle INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "showService";
    locala.GvH.put("showService", "INTEGER default '0' ");
    localStringBuilder.append(" showService INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "messageListStr";
    locala.GvH.put("messageListStr", "TEXT");
    localStringBuilder.append(" messageListStr TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "serviceInfoListStr";
    locala.GvH.put("serviceInfoListStr", "TEXT");
    localStringBuilder.append(" serviceInfoListStr TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "bizAccountListStr";
    locala.GvH.put("bizAccountListStr", "TEXT");
    localStringBuilder.append(" bizAccountListStr TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "cacheTime";
    locala.GvH.put("cacheTime", "LONG default '0' ");
    localStringBuilder.append(" cacheTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "decryptUserName";
    locala.GvH.put("decryptUserName", "TEXT default '' ");
    localStringBuilder.append(" decryptUserName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "hiddenAvatar";
    locala.GvH.put("hiddenAvatar", "INTEGER default '0' ");
    localStringBuilder.append(" hiddenAvatar INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "hiddenButtonBeforeFocus";
    locala.GvH.put("hiddenButtonBeforeFocus", "INTEGER default '0' ");
    localStringBuilder.append(" hiddenButtonBeforeFocus INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "newBanReason";
    locala.GvH.put("newBanReason", "TEXT");
    localStringBuilder.append(" newBanReason TEXT");
    locala.columns[17] = "rowid";
    locala.sql = localStringBuilder.toString();
    hlR = locala;
    AppMethodBeat.o(27585);
  }
  
  public final c.a getDBInfo()
  {
    return hlR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.h
 * JD-Core Version:    0.7.0.1
 */