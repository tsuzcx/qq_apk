package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public class FinderTipsShowEntranceExtInfo
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> multi_username;
  public long object_id;
  public String object_nonce_id;
  public String report_ext_info;
  public b tabTipsByPassInfo;
  public int tab_type;
  public String username;
  
  public FinderTipsShowEntranceExtInfo()
  {
    AppMethodBeat.i(257808);
    this.multi_username = new LinkedList();
    AppMethodBeat.o(257808);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257812);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.object_id);
      if (this.object_nonce_id != null) {
        paramVarArgs.g(2, this.object_nonce_id);
      }
      paramVarArgs.bS(3, this.tab_type);
      if (this.username != null) {
        paramVarArgs.g(4, this.username);
      }
      paramVarArgs.e(5, 1, this.multi_username);
      if (this.report_ext_info != null) {
        paramVarArgs.g(6, this.report_ext_info);
      }
      if (this.tabTipsByPassInfo != null) {
        paramVarArgs.d(7, this.tabTipsByPassInfo);
      }
      AppMethodBeat.o(257812);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.object_id) + 0;
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.object_nonce_id);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.tab_type);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.username);
      }
      i = paramInt + i.a.a.a.c(5, 1, this.multi_username);
      paramInt = i;
      if (this.report_ext_info != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.report_ext_info);
      }
      i = paramInt;
      if (this.tabTipsByPassInfo != null) {
        i = paramInt + i.a.a.b.b.a.c(7, this.tabTipsByPassInfo);
      }
      AppMethodBeat.o(257812);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.multi_username.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257812);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      FinderTipsShowEntranceExtInfo localFinderTipsShowEntranceExtInfo = (FinderTipsShowEntranceExtInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257812);
        return -1;
      case 1: 
        localFinderTipsShowEntranceExtInfo.object_id = locala.ajGk.aaw();
        AppMethodBeat.o(257812);
        return 0;
      case 2: 
        localFinderTipsShowEntranceExtInfo.object_nonce_id = locala.ajGk.readString();
        AppMethodBeat.o(257812);
        return 0;
      case 3: 
        localFinderTipsShowEntranceExtInfo.tab_type = locala.ajGk.aar();
        AppMethodBeat.o(257812);
        return 0;
      case 4: 
        localFinderTipsShowEntranceExtInfo.username = locala.ajGk.readString();
        AppMethodBeat.o(257812);
        return 0;
      case 5: 
        localFinderTipsShowEntranceExtInfo.multi_username.add(locala.ajGk.readString());
        AppMethodBeat.o(257812);
        return 0;
      case 6: 
        localFinderTipsShowEntranceExtInfo.report_ext_info = locala.ajGk.readString();
        AppMethodBeat.o(257812);
        return 0;
      }
      localFinderTipsShowEntranceExtInfo.tabTipsByPassInfo = locala.ajGk.kFX();
      AppMethodBeat.o(257812);
      return 0;
    }
    AppMethodBeat.o(257812);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo
 * JD-Core Version:    0.7.0.1
 */