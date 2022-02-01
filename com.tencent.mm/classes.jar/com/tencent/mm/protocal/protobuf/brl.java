package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class brl
  extends com.tencent.mm.bw.a
{
  public LinkedList<sh> EMe;
  public String FgA;
  public boolean FgB;
  public int FgC;
  public String FgD;
  public int FgE;
  public dho FgF;
  public String Fgx;
  public boolean Fgy;
  public ia Fgz;
  
  public brl()
  {
    AppMethodBeat.i(91533);
    this.EMe = new LinkedList();
    AppMethodBeat.o(91533);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91534);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fgx != null) {
        paramVarArgs.d(1, this.Fgx);
      }
      paramVarArgs.e(2, 8, this.EMe);
      paramVarArgs.bl(3, this.Fgy);
      if (this.Fgz != null)
      {
        paramVarArgs.ln(4, this.Fgz.computeSize());
        this.Fgz.writeFields(paramVarArgs);
      }
      if (this.FgA != null) {
        paramVarArgs.d(5, this.FgA);
      }
      paramVarArgs.bl(6, this.FgB);
      paramVarArgs.aR(7, this.FgC);
      if (this.FgD != null) {
        paramVarArgs.d(8, this.FgD);
      }
      paramVarArgs.aR(9, this.FgE);
      if (this.FgF != null)
      {
        paramVarArgs.ln(10, this.FgF.computeSize());
        this.FgF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91534);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fgx == null) {
        break label962;
      }
    }
    label962:
    for (paramInt = f.a.a.b.b.a.e(1, this.Fgx) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.EMe) + (f.a.a.b.b.a.fK(3) + 1);
      paramInt = i;
      if (this.Fgz != null) {
        paramInt = i + f.a.a.a.lm(4, this.Fgz.computeSize());
      }
      i = paramInt;
      if (this.FgA != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FgA);
      }
      i = i + (f.a.a.b.b.a.fK(6) + 1) + f.a.a.b.b.a.bx(7, this.FgC);
      paramInt = i;
      if (this.FgD != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FgD);
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.FgE);
      paramInt = i;
      if (this.FgF != null) {
        paramInt = i + f.a.a.a.lm(10, this.FgF.computeSize());
      }
      AppMethodBeat.o(91534);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EMe.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91534);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brl localbrl = (brl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91534);
          return -1;
        case 1: 
          localbrl.Fgx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91534);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrl.EMe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91534);
          return 0;
        case 3: 
          localbrl.Fgy = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91534);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ia();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ia)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrl.Fgz = ((ia)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91534);
          return 0;
        case 5: 
          localbrl.FgA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91534);
          return 0;
        case 6: 
          localbrl.FgB = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91534);
          return 0;
        case 7: 
          localbrl.FgC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91534);
          return 0;
        case 8: 
          localbrl.FgD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91534);
          return 0;
        case 9: 
          localbrl.FgE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91534);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dho();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dho)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbrl.FgF = ((dho)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91534);
        return 0;
      }
      AppMethodBeat.o(91534);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brl
 * JD-Core Version:    0.7.0.1
 */