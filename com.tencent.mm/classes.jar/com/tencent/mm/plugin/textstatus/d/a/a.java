package com.tencent.mm.plugin.textstatus.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.plugin.textstatus.proto.TextStatusEmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"convertToBaseEmojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusEmojiInfo;", "plugin-textstatus_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final EmojiInfo a(TextStatusEmojiInfo paramTextStatusEmojiInfo)
  {
    AppMethodBeat.i(289739);
    s.u(paramTextStatusEmojiInfo, "<this>");
    EmojiInfo localEmojiInfo = new EmojiInfo();
    localEmojiInfo.field_md5 = d.gP(paramTextStatusEmojiInfo.Md5, localEmojiInfo.field_md5);
    localEmojiInfo.field_cdnUrl = d.gP(paramTextStatusEmojiInfo.Url, localEmojiInfo.field_cdnUrl);
    localEmojiInfo.field_thumbUrl = d.gP(paramTextStatusEmojiInfo.ThumbUrl, localEmojiInfo.field_thumbUrl);
    localEmojiInfo.field_designerID = d.gP(paramTextStatusEmojiInfo.DesignerID, localEmojiInfo.field_designerID);
    localEmojiInfo.field_encrypturl = d.gP(paramTextStatusEmojiInfo.EncryptUrl, localEmojiInfo.field_encrypturl);
    localEmojiInfo.field_aeskey = d.gP(paramTextStatusEmojiInfo.AesKey, localEmojiInfo.field_aeskey);
    localEmojiInfo.field_groupId = d.gP(paramTextStatusEmojiInfo.ProductID, localEmojiInfo.field_groupId);
    localEmojiInfo.field_externUrl = d.gP(paramTextStatusEmojiInfo.ExternUrl, localEmojiInfo.field_externUrl);
    localEmojiInfo.field_externMd5 = d.gP(paramTextStatusEmojiInfo.ExternMd5, localEmojiInfo.field_externMd5);
    localEmojiInfo.field_activityid = d.gP(paramTextStatusEmojiInfo.ActivityID, localEmojiInfo.field_activityid);
    localEmojiInfo.field_attachedText = d.gP(paramTextStatusEmojiInfo.AttachedText, localEmojiInfo.field_attachedText);
    localEmojiInfo.field_attachTextColor = d.gP(paramTextStatusEmojiInfo.AttachedTextColor, localEmojiInfo.field_attachTextColor);
    localEmojiInfo.field_lensId = d.gP(paramTextStatusEmojiInfo.LensId, localEmojiInfo.field_lensId);
    AppMethodBeat.o(289739);
    return localEmojiInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.d.a.a
 * JD-Core Version:    0.7.0.1
 */