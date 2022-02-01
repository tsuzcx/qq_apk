package com.tencent.mm.plugin.vlog.model.panel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"TAG", "", "pagGroupId", "getPagGroupId", "()Ljava/lang/String;", "pagIconList", "", "pagItemType", "", "getPagItemType", "()I", "pagList", "createPagGroupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "plugin-vlog_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final String TAG;
  private static final int Ucb;
  private static final String Ucc;
  private static final List<String> Ucd;
  private static final List<String> Uce;
  
  static
  {
    AppMethodBeat.i(283705);
    Ucb = 108;
    Ucc = "pag_panel";
    TAG = "MicroMsg.PagEmojiPanel";
    Ucd = p.listOf(new String[] { "2020051501 (0-00-01-00).png", "2020051502 (0-00-01-18).png", "2020051503 (0-00-01-05).png", "2020051504 (0-00-01-24).png", "2020051901 (0-00-01-13).png", "2020051902 (0-00-01-13).png", "2020051903 (0-00-01-03).png", "2020051904 (0-00-01-14).png", "2020051905 (0-00-00-25).png", "2020051906 (0-00-01-12).png", "2020051907 (0-00-01-18).png", "2020052001 (0-00-01-18).png", "2020052002 (0-00-01-00).png", "2020052003 (0-00-00-24).png", "2020052004 (0-00-00-14).png", "2020052005 (0-00-01-06).png", "2020052006 (0-00-00-25).png", "2020052007 (0-00-00-16).png" });
    Uce = p.listOf(new String[] { "2020051501.pag", "2020051502.pag", "2020051503.pag", "2020051504.pag", "2020051901.pag", "2020051902.pag", "2020051903.pag", "2020051904.pag", "2020051905.pag", "2020051906.pag", "2020051907.pag", "2020052001.pag", "2020052002.pag", "2020052003.pag", "2020052004.pag", "2020052005.pag", "2020052006.pag", "2020052007.pag" });
    AppMethodBeat.o(283705);
  }
  
  public static final int hRI()
  {
    return Ucb;
  }
  
  public static final String hRJ()
  {
    return Ucc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.b
 * JD-Core Version:    0.7.0.1
 */