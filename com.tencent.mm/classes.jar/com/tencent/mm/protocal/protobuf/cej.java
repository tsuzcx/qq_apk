package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cej
  extends com.tencent.mm.bw.a
{
  public String FaI;
  public int FsZ;
  public String Fta;
  public int Ftb;
  public String Ftc;
  public int Ftd;
  public String Fte;
  public long Ftf;
  public LinkedList<cdy> Ftg;
  public String hJq;
  public String vxl;
  public String wLA;
  
  public cej()
  {
    AppMethodBeat.i(91593);
    this.Ftg = new LinkedList();
    AppMethodBeat.o(91593);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91594);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FsZ);
      if (this.Fta != null) {
        paramVarArgs.d(2, this.Fta);
      }
      if (this.FaI != null) {
        paramVarArgs.d(3, this.FaI);
      }
      paramVarArgs.aR(4, this.Ftb);
      if (this.vxl != null) {
        paramVarArgs.d(5, this.vxl);
      }
      if (this.Ftc != null) {
        paramVarArgs.d(6, this.Ftc);
      }
      if (this.wLA != null) {
        paramVarArgs.d(7, this.wLA);
      }
      paramVarArgs.aR(8, this.Ftd);
      if (this.hJq != null) {
        paramVarArgs.d(9, this.hJq);
      }
      if (this.Fte != null) {
        paramVarArgs.d(10, this.Fte);
      }
      paramVarArgs.aO(11, this.Ftf);
      paramVarArgs.e(12, 8, this.Ftg);
      AppMethodBeat.o(91594);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.FsZ) + 0;
      paramInt = i;
      if (this.Fta != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Fta);
      }
      i = paramInt;
      if (this.FaI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FaI);
      }
      i += f.a.a.b.b.a.bx(4, this.Ftb);
      paramInt = i;
      if (this.vxl != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.vxl);
      }
      i = paramInt;
      if (this.Ftc != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Ftc);
      }
      paramInt = i;
      if (this.wLA != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.wLA);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.Ftd);
      paramInt = i;
      if (this.hJq != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.hJq);
      }
      i = paramInt;
      if (this.Fte != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Fte);
      }
      paramInt = f.a.a.b.b.a.p(11, this.Ftf);
      int j = f.a.a.a.c(12, 8, this.Ftg);
      AppMethodBeat.o(91594);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Ftg.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91594);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cej localcej = (cej)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91594);
        return -1;
      case 1: 
        localcej.FsZ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91594);
        return 0;
      case 2: 
        localcej.Fta = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 3: 
        localcej.FaI = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 4: 
        localcej.Ftb = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91594);
        return 0;
      case 5: 
        localcej.vxl = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 6: 
        localcej.Ftc = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 7: 
        localcej.wLA = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 8: 
        localcej.Ftd = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91594);
        return 0;
      case 9: 
        localcej.hJq = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 10: 
        localcej.Fte = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 11: 
        localcej.Ftf = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(91594);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cdy();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cdy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcej.Ftg.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91594);
      return 0;
    }
    AppMethodBeat.o(91594);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cej
 * JD-Core Version:    0.7.0.1
 */