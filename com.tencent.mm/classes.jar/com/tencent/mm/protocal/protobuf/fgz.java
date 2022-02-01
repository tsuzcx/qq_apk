package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fgz
  extends com.tencent.mm.bx.a
{
  public String Vyi;
  public String abHo;
  public LinkedList<bv> abHp;
  public int abHq;
  public int abHr;
  
  public fgz()
  {
    AppMethodBeat.i(257577);
    this.abHp = new LinkedList();
    AppMethodBeat.o(257577);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257585);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Vyi != null) {
        paramVarArgs.g(1, this.Vyi);
      }
      if (this.abHo != null) {
        paramVarArgs.g(2, this.abHo);
      }
      paramVarArgs.e(3, 8, this.abHp);
      paramVarArgs.bS(4, this.abHq);
      paramVarArgs.bS(5, this.abHr);
      AppMethodBeat.o(257585);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Vyi == null) {
        break label484;
      }
    }
    label484:
    for (paramInt = i.a.a.b.b.a.h(1, this.Vyi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abHo != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abHo);
      }
      paramInt = i.a.a.a.c(3, 8, this.abHp);
      int j = i.a.a.b.b.a.cJ(4, this.abHq);
      int k = i.a.a.b.b.a.cJ(5, this.abHr);
      AppMethodBeat.o(257585);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abHp.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257585);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fgz localfgz = (fgz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257585);
          return -1;
        case 1: 
          localfgz.Vyi = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257585);
          return 0;
        case 2: 
          localfgz.abHo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257585);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bv localbv = new bv();
            if ((localObject != null) && (localObject.length > 0)) {
              localbv.parseFrom((byte[])localObject);
            }
            localfgz.abHp.add(localbv);
            paramInt += 1;
          }
          AppMethodBeat.o(257585);
          return 0;
        case 4: 
          localfgz.abHq = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257585);
          return 0;
        }
        localfgz.abHr = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257585);
        return 0;
      }
      AppMethodBeat.o(257585);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgz
 * JD-Core Version:    0.7.0.1
 */