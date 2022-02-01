package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fu
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String IMg;
  public String IMh;
  public int IcB;
  public String IcK;
  public String YFJ;
  public int YHj;
  public String YHk;
  public gol YHl;
  public int YHm;
  public String YHn;
  public String YHo;
  public String YHp;
  public int YHq;
  public String nUB;
  public String oOI;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32116);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IMh != null) {
        paramVarArgs.g(1, this.IMh);
      }
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      paramVarArgs.bS(3, this.YHj);
      if (this.IMg != null) {
        paramVarArgs.g(4, this.IMg);
      }
      paramVarArgs.bS(5, this.vhJ);
      if (this.nUB != null) {
        paramVarArgs.g(6, this.nUB);
      }
      paramVarArgs.bS(7, this.CreateTime);
      if (this.YHk != null) {
        paramVarArgs.g(8, this.YHk);
      }
      if (this.YHl != null)
      {
        paramVarArgs.qD(9, this.YHl.computeSize());
        this.YHl.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(10, this.IcB);
      paramVarArgs.bS(11, this.YHm);
      if (this.YFJ != null) {
        paramVarArgs.g(12, this.YFJ);
      }
      if (this.YHn != null) {
        paramVarArgs.g(13, this.YHn);
      }
      if (this.YHo != null) {
        paramVarArgs.g(14, this.YHo);
      }
      if (this.YHp != null) {
        paramVarArgs.g(15, this.YHp);
      }
      paramVarArgs.bS(16, this.YHq);
      if (this.IcK != null) {
        paramVarArgs.g(17, this.IcK);
      }
      AppMethodBeat.o(32116);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IMh == null) {
        break label1195;
      }
    }
    label1195:
    for (paramInt = i.a.a.b.b.a.h(1, this.IMh) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oOI != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.oOI);
      }
      i += i.a.a.b.b.a.cJ(3, this.YHj);
      paramInt = i;
      if (this.IMg != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IMg);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.vhJ);
      paramInt = i;
      if (this.nUB != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.nUB);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.CreateTime);
      paramInt = i;
      if (this.YHk != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YHk);
      }
      i = paramInt;
      if (this.YHl != null) {
        i = paramInt + i.a.a.a.qC(9, this.YHl.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(10, this.IcB) + i.a.a.b.b.a.cJ(11, this.YHm);
      paramInt = i;
      if (this.YFJ != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.YFJ);
      }
      i = paramInt;
      if (this.YHn != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.YHn);
      }
      paramInt = i;
      if (this.YHo != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.YHo);
      }
      i = paramInt;
      if (this.YHp != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.YHp);
      }
      i += i.a.a.b.b.a.cJ(16, this.YHq);
      paramInt = i;
      if (this.IcK != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.IcK);
      }
      AppMethodBeat.o(32116);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32116);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fu localfu = (fu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32116);
          return -1;
        case 1: 
          localfu.IMh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 2: 
          localfu.oOI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 3: 
          localfu.YHj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32116);
          return 0;
        case 4: 
          localfu.IMg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 5: 
          localfu.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32116);
          return 0;
        case 6: 
          localfu.nUB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 7: 
          localfu.CreateTime = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32116);
          return 0;
        case 8: 
          localfu.YHk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gol localgol = new gol();
            if ((localObject != null) && (localObject.length > 0)) {
              localgol.dg((byte[])localObject);
            }
            localfu.YHl = localgol;
            paramInt += 1;
          }
          AppMethodBeat.o(32116);
          return 0;
        case 10: 
          localfu.IcB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32116);
          return 0;
        case 11: 
          localfu.YHm = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32116);
          return 0;
        case 12: 
          localfu.YFJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 13: 
          localfu.YHn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 14: 
          localfu.YHo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 15: 
          localfu.YHp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 16: 
          localfu.YHq = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32116);
          return 0;
        }
        localfu.IcK = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32116);
        return 0;
      }
      AppMethodBeat.o(32116);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fu
 * JD-Core Version:    0.7.0.1
 */