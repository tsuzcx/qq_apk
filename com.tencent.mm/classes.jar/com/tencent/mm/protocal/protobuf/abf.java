package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abf
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public int GaP;
  public LinkedList<byn> GaQ;
  public int GaR;
  public String GaS;
  public bww GaT;
  public arj GaU;
  public ark GaV;
  public jb GaW;
  public String Title;
  public String Url;
  
  public abf()
  {
    AppMethodBeat.i(125718);
    this.GaQ = new LinkedList();
    AppMethodBeat.o(125718);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125719);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Desc != null) {
        paramVarArgs.d(1, this.Desc);
      }
      paramVarArgs.aS(2, this.GaP);
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.Url != null) {
        paramVarArgs.d(4, this.Url);
      }
      paramVarArgs.e(5, 8, this.GaQ);
      paramVarArgs.aS(6, this.GaR);
      if (this.GaS != null) {
        paramVarArgs.d(7, this.GaS);
      }
      if (this.GaT != null)
      {
        paramVarArgs.lC(8, this.GaT.computeSize());
        this.GaT.writeFields(paramVarArgs);
      }
      if (this.GaU != null)
      {
        paramVarArgs.lC(9, this.GaU.computeSize());
        this.GaU.writeFields(paramVarArgs);
      }
      if (this.GaV != null)
      {
        paramVarArgs.lC(10, this.GaV.computeSize());
        this.GaV.writeFields(paramVarArgs);
      }
      if (this.GaW != null)
      {
        paramVarArgs.lC(11, this.GaW.computeSize());
        this.GaW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Desc == null) {
        break label1250;
      }
    }
    label1250:
    for (paramInt = f.a.a.b.b.a.e(1, this.Desc) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GaP);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Title);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Url);
      }
      i = i + f.a.a.a.c(5, 8, this.GaQ) + f.a.a.b.b.a.bz(6, this.GaR);
      paramInt = i;
      if (this.GaS != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GaS);
      }
      i = paramInt;
      if (this.GaT != null) {
        i = paramInt + f.a.a.a.lB(8, this.GaT.computeSize());
      }
      paramInt = i;
      if (this.GaU != null) {
        paramInt = i + f.a.a.a.lB(9, this.GaU.computeSize());
      }
      i = paramInt;
      if (this.GaV != null) {
        i = paramInt + f.a.a.a.lB(10, this.GaV.computeSize());
      }
      paramInt = i;
      if (this.GaW != null) {
        paramInt = i + f.a.a.a.lB(11, this.GaW.computeSize());
      }
      AppMethodBeat.o(125719);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GaQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125719);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        abf localabf = (abf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125719);
          return -1;
        case 1: 
          localabf.Desc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 2: 
          localabf.GaP = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125719);
          return 0;
        case 3: 
          localabf.Title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 4: 
          localabf.Url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((byn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabf.GaQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 6: 
          localabf.GaR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125719);
          return 0;
        case 7: 
          localabf.GaS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125719);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bww();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bww)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabf.GaT = ((bww)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new arj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((arj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabf.GaU = ((arj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ark();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ark)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabf.GaV = ((ark)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125719);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new jb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((jb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabf.GaW = ((jb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125719);
        return 0;
      }
      AppMethodBeat.o(125719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abf
 * JD-Core Version:    0.7.0.1
 */