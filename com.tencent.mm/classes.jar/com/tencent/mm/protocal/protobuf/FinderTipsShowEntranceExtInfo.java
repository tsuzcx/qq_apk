package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public class FinderTipsShowEntranceExtInfo
  extends com.tencent.mm.cd.a
{
  public String multi_username;
  public long object_id;
  public String object_nonce_id;
  public String report_ext_info;
  public b tabTipsByPassInfo;
  public int tab_type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199690);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.object_id);
      if (this.object_nonce_id != null) {
        paramVarArgs.f(2, this.object_nonce_id);
      }
      paramVarArgs.aY(3, this.tab_type);
      if (this.username != null) {
        paramVarArgs.f(4, this.username);
      }
      if (this.multi_username != null) {
        paramVarArgs.f(5, this.multi_username);
      }
      if (this.report_ext_info != null) {
        paramVarArgs.f(6, this.report_ext_info);
      }
      if (this.tabTipsByPassInfo != null) {
        paramVarArgs.c(7, this.tabTipsByPassInfo);
      }
      AppMethodBeat.o(199690);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.object_id) + 0;
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.object_nonce_id);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.tab_type);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.username);
      }
      i = paramInt;
      if (this.multi_username != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.multi_username);
      }
      paramInt = i;
      if (this.report_ext_info != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.report_ext_info);
      }
      i = paramInt;
      if (this.tabTipsByPassInfo != null) {
        i = paramInt + g.a.a.b.b.a.b(7, this.tabTipsByPassInfo);
      }
      AppMethodBeat.o(199690);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(199690);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      FinderTipsShowEntranceExtInfo localFinderTipsShowEntranceExtInfo = (FinderTipsShowEntranceExtInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(199690);
        return -1;
      case 1: 
        localFinderTipsShowEntranceExtInfo.object_id = locala.abFh.AN();
        AppMethodBeat.o(199690);
        return 0;
      case 2: 
        localFinderTipsShowEntranceExtInfo.object_nonce_id = locala.abFh.readString();
        AppMethodBeat.o(199690);
        return 0;
      case 3: 
        localFinderTipsShowEntranceExtInfo.tab_type = locala.abFh.AK();
        AppMethodBeat.o(199690);
        return 0;
      case 4: 
        localFinderTipsShowEntranceExtInfo.username = locala.abFh.readString();
        AppMethodBeat.o(199690);
        return 0;
      case 5: 
        localFinderTipsShowEntranceExtInfo.multi_username = locala.abFh.readString();
        AppMethodBeat.o(199690);
        return 0;
      case 6: 
        localFinderTipsShowEntranceExtInfo.report_ext_info = locala.abFh.readString();
        AppMethodBeat.o(199690);
        return 0;
      }
      localFinderTipsShowEntranceExtInfo.tabTipsByPassInfo = locala.abFh.iUw();
      AppMethodBeat.o(199690);
      return 0;
    }
    AppMethodBeat.o(199690);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo
 * JD-Core Version:    0.7.0.1
 */