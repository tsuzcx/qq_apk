package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aos
  extends com.tencent.mm.cd.a
{
  public String Ila;
  public LinkedList<aot> RZg;
  public String SBk;
  public long SBl;
  public long SBm;
  public String SBn;
  public long SBo;
  public String SiM;
  
  public aos()
  {
    AppMethodBeat.i(91458);
    this.RZg = new LinkedList();
    AppMethodBeat.o(91458);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91459);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SBk != null) {
        paramVarArgs.f(1, this.SBk);
      }
      paramVarArgs.e(2, 8, this.RZg);
      paramVarArgs.bm(3, this.SBl);
      paramVarArgs.bm(4, this.SBm);
      if (this.SBn != null) {
        paramVarArgs.f(5, this.SBn);
      }
      if (this.Ila != null) {
        paramVarArgs.f(6, this.Ila);
      }
      paramVarArgs.bm(7, this.SBo);
      if (this.SiM != null) {
        paramVarArgs.f(8, this.SiM);
      }
      AppMethodBeat.o(91459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SBk == null) {
        break label648;
      }
    }
    label648:
    for (paramInt = g.a.a.b.b.a.g(1, this.SBk) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.RZg) + g.a.a.b.b.a.p(3, this.SBl) + g.a.a.b.b.a.p(4, this.SBm);
      paramInt = i;
      if (this.SBn != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SBn);
      }
      i = paramInt;
      if (this.Ila != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Ila);
      }
      i += g.a.a.b.b.a.p(7, this.SBo);
      paramInt = i;
      if (this.SiM != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.SiM);
      }
      AppMethodBeat.o(91459);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RZg.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91459);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        aos localaos = (aos)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91459);
          return -1;
        case 1: 
          localaos.SBk = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            aot localaot = new aot();
            if ((localObject != null) && (localObject.length > 0)) {
              localaot.parseFrom((byte[])localObject);
            }
            localaos.RZg.add(localaot);
            paramInt += 1;
          }
          AppMethodBeat.o(91459);
          return 0;
        case 3: 
          localaos.SBl = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(91459);
          return 0;
        case 4: 
          localaos.SBm = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(91459);
          return 0;
        case 5: 
          localaos.SBn = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 6: 
          localaos.Ila = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 7: 
          localaos.SBo = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(91459);
          return 0;
        }
        localaos.SiM = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91459);
        return 0;
      }
      AppMethodBeat.o(91459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aos
 * JD-Core Version:    0.7.0.1
 */