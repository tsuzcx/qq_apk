package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dih
  extends com.tencent.mm.bw.a
{
  public int FRi;
  public int FRj;
  public String FRk;
  public dig FRl;
  public boolean daU;
  public int hbI;
  public String id;
  public String kut;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153001);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FRi);
      paramVarArgs.aR(2, this.hbI);
      paramVarArgs.aR(3, this.FRj);
      paramVarArgs.aR(4, this.type);
      if (this.id != null) {
        paramVarArgs.d(5, this.id);
      }
      if (this.kut != null) {
        paramVarArgs.d(6, this.kut);
      }
      if (this.FRk != null) {
        paramVarArgs.d(7, this.FRk);
      }
      if (this.FRl != null)
      {
        paramVarArgs.ln(8, this.FRl.computeSize());
        this.FRl.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(9, this.daU);
      AppMethodBeat.o(153001);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.FRi) + 0 + f.a.a.b.b.a.bx(2, this.hbI) + f.a.a.b.b.a.bx(3, this.FRj) + f.a.a.b.b.a.bx(4, this.type);
      paramInt = i;
      if (this.id != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.id);
      }
      i = paramInt;
      if (this.kut != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.kut);
      }
      paramInt = i;
      if (this.FRk != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FRk);
      }
      i = paramInt;
      if (this.FRl != null) {
        i = paramInt + f.a.a.a.lm(8, this.FRl.computeSize());
      }
      paramInt = f.a.a.b.b.a.fK(9);
      AppMethodBeat.o(153001);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(153001);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dih localdih = (dih)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153001);
        return -1;
      case 1: 
        localdih.FRi = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(153001);
        return 0;
      case 2: 
        localdih.hbI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(153001);
        return 0;
      case 3: 
        localdih.FRj = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(153001);
        return 0;
      case 4: 
        localdih.type = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(153001);
        return 0;
      case 5: 
        localdih.id = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 6: 
        localdih.kut = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 7: 
        localdih.FRk = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dig();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dig)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdih.FRl = ((dig)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153001);
        return 0;
      }
      localdih.daU = ((f.a.a.a.a)localObject1).LVo.fZX();
      AppMethodBeat.o(153001);
      return 0;
    }
    AppMethodBeat.o(153001);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dih
 * JD-Core Version:    0.7.0.1
 */