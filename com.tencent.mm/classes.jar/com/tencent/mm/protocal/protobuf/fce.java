package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class fce
  extends com.tencent.mm.cd.a
{
  public long SoR;
  public String Sob;
  public String UBS;
  public String UBT;
  public String UCf;
  public b UCg;
  public LinkedList<fcn> UCh;
  
  public fce()
  {
    AppMethodBeat.i(200758);
    this.UCh = new LinkedList();
    AppMethodBeat.o(200758);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200767);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UBS != null) {
        paramVarArgs.f(1, this.UBS);
      }
      paramVarArgs.bm(2, this.SoR);
      if (this.UBT != null) {
        paramVarArgs.f(3, this.UBT);
      }
      if (this.UCf != null) {
        paramVarArgs.f(4, this.UCf);
      }
      if (this.Sob != null) {
        paramVarArgs.f(5, this.Sob);
      }
      if (this.UCg != null) {
        paramVarArgs.c(6, this.UCg);
      }
      paramVarArgs.e(7, 8, this.UCh);
      AppMethodBeat.o(200767);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UBS == null) {
        break label624;
      }
    }
    label624:
    for (paramInt = g.a.a.b.b.a.g(1, this.UBS) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.SoR);
      paramInt = i;
      if (this.UBT != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.UBT);
      }
      i = paramInt;
      if (this.UCf != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.UCf);
      }
      paramInt = i;
      if (this.Sob != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Sob);
      }
      i = paramInt;
      if (this.UCg != null) {
        i = paramInt + g.a.a.b.b.a.b(6, this.UCg);
      }
      paramInt = g.a.a.a.c(7, 8, this.UCh);
      AppMethodBeat.o(200767);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UCh.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(200767);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fce localfce = (fce)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200767);
          return -1;
        case 1: 
          localfce.UBS = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(200767);
          return 0;
        case 2: 
          localfce.SoR = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(200767);
          return 0;
        case 3: 
          localfce.UBT = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(200767);
          return 0;
        case 4: 
          localfce.UCf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(200767);
          return 0;
        case 5: 
          localfce.Sob = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(200767);
          return 0;
        case 6: 
          localfce.UCg = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(200767);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fcn localfcn = new fcn();
          if ((localObject != null) && (localObject.length > 0)) {
            localfcn.parseFrom((byte[])localObject);
          }
          localfce.UCh.add(localfcn);
          paramInt += 1;
        }
        AppMethodBeat.o(200767);
        return 0;
      }
      AppMethodBeat.o(200767);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fce
 * JD-Core Version:    0.7.0.1
 */