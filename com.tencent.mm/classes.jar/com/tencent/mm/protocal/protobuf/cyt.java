package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cyt
  extends com.tencent.mm.bx.a
{
  public String FVo;
  public String FVp;
  public cwt GKC;
  public int GNU;
  public String GNV;
  public String GNW;
  public String GNX;
  public int GNY;
  public cwt GbY;
  public acg HpG;
  public int jdc;
  public String jdd;
  public String jde;
  public String jdf;
  public int jdg;
  public String jdh;
  public String jdl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117918);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GbY == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(117918);
        throw paramVarArgs;
      }
      if (this.GKC == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(117918);
        throw paramVarArgs;
      }
      if (this.GbY != null)
      {
        paramVarArgs.lC(1, this.GbY.computeSize());
        this.GbY.writeFields(paramVarArgs);
      }
      if (this.GKC != null)
      {
        paramVarArgs.lC(2, this.GKC.computeSize());
        this.GKC.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.jdc);
      if (this.jdd != null) {
        paramVarArgs.d(4, this.jdd);
      }
      if (this.jde != null) {
        paramVarArgs.d(5, this.jde);
      }
      if (this.jdf != null) {
        paramVarArgs.d(6, this.jdf);
      }
      paramVarArgs.aS(7, this.jdg);
      paramVarArgs.aS(8, this.GNU);
      if (this.GNV != null) {
        paramVarArgs.d(9, this.GNV);
      }
      if (this.GNW != null) {
        paramVarArgs.d(10, this.GNW);
      }
      if (this.jdh != null) {
        paramVarArgs.d(11, this.jdh);
      }
      if (this.GNX != null) {
        paramVarArgs.d(12, this.GNX);
      }
      paramVarArgs.aS(13, this.GNY);
      if (this.jdl != null) {
        paramVarArgs.d(14, this.jdl);
      }
      if (this.HpG != null)
      {
        paramVarArgs.lC(15, this.HpG.computeSize());
        this.HpG.writeFields(paramVarArgs);
      }
      if (this.FVo != null) {
        paramVarArgs.d(16, this.FVo);
      }
      if (this.FVp != null) {
        paramVarArgs.d(17, this.FVp);
      }
      AppMethodBeat.o(117918);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GbY == null) {
        break label1514;
      }
    }
    label1514:
    for (paramInt = f.a.a.a.lB(1, this.GbY.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GKC != null) {
        i = paramInt + f.a.a.a.lB(2, this.GKC.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.jdc);
      paramInt = i;
      if (this.jdd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.jdd);
      }
      i = paramInt;
      if (this.jde != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.jde);
      }
      paramInt = i;
      if (this.jdf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.jdf);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.jdg) + f.a.a.b.b.a.bz(8, this.GNU);
      paramInt = i;
      if (this.GNV != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GNV);
      }
      i = paramInt;
      if (this.GNW != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GNW);
      }
      paramInt = i;
      if (this.jdh != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.jdh);
      }
      i = paramInt;
      if (this.GNX != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GNX);
      }
      i += f.a.a.b.b.a.bz(13, this.GNY);
      paramInt = i;
      if (this.jdl != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.jdl);
      }
      i = paramInt;
      if (this.HpG != null) {
        i = paramInt + f.a.a.a.lB(15, this.HpG.computeSize());
      }
      paramInt = i;
      if (this.FVo != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.FVo);
      }
      i = paramInt;
      if (this.FVp != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.FVp);
      }
      AppMethodBeat.o(117918);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GbY == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(117918);
          throw paramVarArgs;
        }
        if (this.GKC == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(117918);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117918);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cyt localcyt = (cyt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117918);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyt.GbY = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117918);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyt.GKC = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117918);
          return 0;
        case 3: 
          localcyt.jdc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117918);
          return 0;
        case 4: 
          localcyt.jdd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 5: 
          localcyt.jde = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 6: 
          localcyt.jdf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 7: 
          localcyt.jdg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117918);
          return 0;
        case 8: 
          localcyt.GNU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117918);
          return 0;
        case 9: 
          localcyt.GNV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 10: 
          localcyt.GNW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 11: 
          localcyt.jdh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 12: 
          localcyt.GNX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 13: 
          localcyt.GNY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(117918);
          return 0;
        case 14: 
          localcyt.jdl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyt.HpG = ((acg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117918);
          return 0;
        case 16: 
          localcyt.FVo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117918);
          return 0;
        }
        localcyt.FVp = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117918);
        return 0;
      }
      AppMethodBeat.o(117918);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyt
 * JD-Core Version:    0.7.0.1
 */