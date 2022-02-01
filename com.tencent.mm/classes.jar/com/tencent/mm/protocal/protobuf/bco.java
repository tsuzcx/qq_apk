package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bco
  extends com.tencent.mm.bx.a
{
  public long AyP;
  public long ZNA;
  public avo ZNB;
  public int ZNz;
  public String hLv;
  public int likeFlag;
  public String nVs;
  public String nickName;
  public int unreadFlag;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259284);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nickName != null) {
        paramVarArgs.g(1, this.nickName);
      }
      if (this.nVs != null) {
        paramVarArgs.g(2, this.nVs);
      }
      paramVarArgs.bv(3, this.AyP);
      paramVarArgs.bS(4, this.likeFlag);
      paramVarArgs.bS(5, this.ZNz);
      if (this.hLv != null) {
        paramVarArgs.g(6, this.hLv);
      }
      paramVarArgs.bv(7, this.ZNA);
      paramVarArgs.bS(8, this.unreadFlag);
      if (this.ZNB != null)
      {
        paramVarArgs.qD(9, this.ZNB.computeSize());
        this.ZNB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259284);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickName == null) {
        break label688;
      }
    }
    label688:
    for (paramInt = i.a.a.b.b.a.h(1, this.nickName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nVs != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.nVs);
      }
      i = i + i.a.a.b.b.a.q(3, this.AyP) + i.a.a.b.b.a.cJ(4, this.likeFlag) + i.a.a.b.b.a.cJ(5, this.ZNz);
      paramInt = i;
      if (this.hLv != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.hLv);
      }
      i = paramInt + i.a.a.b.b.a.q(7, this.ZNA) + i.a.a.b.b.a.cJ(8, this.unreadFlag);
      paramInt = i;
      if (this.ZNB != null) {
        paramInt = i + i.a.a.a.qC(9, this.ZNB.computeSize());
      }
      AppMethodBeat.o(259284);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259284);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bco localbco = (bco)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259284);
          return -1;
        case 1: 
          localbco.nickName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259284);
          return 0;
        case 2: 
          localbco.nVs = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259284);
          return 0;
        case 3: 
          localbco.AyP = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259284);
          return 0;
        case 4: 
          localbco.likeFlag = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259284);
          return 0;
        case 5: 
          localbco.ZNz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259284);
          return 0;
        case 6: 
          localbco.hLv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259284);
          return 0;
        case 7: 
          localbco.ZNA = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259284);
          return 0;
        case 8: 
          localbco.unreadFlag = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259284);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          avo localavo = new avo();
          if ((localObject != null) && (localObject.length > 0)) {
            localavo.parseFrom((byte[])localObject);
          }
          localbco.ZNB = localavo;
          paramInt += 1;
        }
        AppMethodBeat.o(259284);
        return 0;
      }
      AppMethodBeat.o(259284);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bco
 * JD-Core Version:    0.7.0.1
 */