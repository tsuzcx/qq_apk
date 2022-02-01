package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class esr
  extends com.tencent.mm.cd.a
{
  public int MFF;
  public int Uur;
  public String Uus;
  public esq Uut;
  public int endTime;
  public boolean fxt;
  public String id;
  public String oWx;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153001);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.MFF);
      paramVarArgs.aY(2, this.endTime);
      paramVarArgs.aY(3, this.Uur);
      paramVarArgs.aY(4, this.type);
      if (this.id != null) {
        paramVarArgs.f(5, this.id);
      }
      if (this.oWx != null) {
        paramVarArgs.f(6, this.oWx);
      }
      if (this.Uus != null) {
        paramVarArgs.f(7, this.Uus);
      }
      if (this.Uut != null)
      {
        paramVarArgs.oE(8, this.Uut.computeSize());
        this.Uut.writeFields(paramVarArgs);
      }
      paramVarArgs.co(9, this.fxt);
      AppMethodBeat.o(153001);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.MFF) + 0 + g.a.a.b.b.a.bM(2, this.endTime) + g.a.a.b.b.a.bM(3, this.Uur) + g.a.a.b.b.a.bM(4, this.type);
      paramInt = i;
      if (this.id != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.id);
      }
      i = paramInt;
      if (this.oWx != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.oWx);
      }
      paramInt = i;
      if (this.Uus != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Uus);
      }
      i = paramInt;
      if (this.Uut != null) {
        i = paramInt + g.a.a.a.oD(8, this.Uut.computeSize());
      }
      paramInt = g.a.a.b.b.a.gL(9);
      AppMethodBeat.o(153001);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(153001);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      esr localesr = (esr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153001);
        return -1;
      case 1: 
        localesr.MFF = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(153001);
        return 0;
      case 2: 
        localesr.endTime = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(153001);
        return 0;
      case 3: 
        localesr.Uur = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(153001);
        return 0;
      case 4: 
        localesr.type = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(153001);
        return 0;
      case 5: 
        localesr.id = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 6: 
        localesr.oWx = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 7: 
        localesr.Uus = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(153001);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          esq localesq = new esq();
          if ((localObject != null) && (localObject.length > 0)) {
            localesq.parseFrom((byte[])localObject);
          }
          localesr.Uut = localesq;
          paramInt += 1;
        }
        AppMethodBeat.o(153001);
        return 0;
      }
      localesr.fxt = ((g.a.a.a.a)localObject).abFh.AB();
      AppMethodBeat.o(153001);
      return 0;
    }
    AppMethodBeat.o(153001);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esr
 * JD-Core Version:    0.7.0.1
 */