package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsg
  extends com.tencent.mm.cd.a
{
  public String Tco;
  public wg Tcu;
  public String Tcv;
  public boolean Tcw;
  public int Tcx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114024);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Tcu != null)
      {
        paramVarArgs.oE(1, this.Tcu.computeSize());
        this.Tcu.writeFields(paramVarArgs);
      }
      if (this.Tco != null) {
        paramVarArgs.f(2, this.Tco);
      }
      if (this.Tcv != null) {
        paramVarArgs.f(3, this.Tcv);
      }
      paramVarArgs.co(4, this.Tcw);
      paramVarArgs.aY(5, this.Tcx);
      AppMethodBeat.o(114024);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Tcu == null) {
        break label496;
      }
    }
    label496:
    for (int i = g.a.a.a.oD(1, this.Tcu.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Tco != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Tco);
      }
      i = paramInt;
      if (this.Tcv != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Tcv);
      }
      paramInt = g.a.a.b.b.a.gL(4);
      int j = g.a.a.b.b.a.bM(5, this.Tcx);
      AppMethodBeat.o(114024);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(114024);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bsg localbsg = (bsg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114024);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            wg localwg = new wg();
            if ((localObject != null) && (localObject.length > 0)) {
              localwg.parseFrom((byte[])localObject);
            }
            localbsg.Tcu = localwg;
            paramInt += 1;
          }
          AppMethodBeat.o(114024);
          return 0;
        case 2: 
          localbsg.Tco = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114024);
          return 0;
        case 3: 
          localbsg.Tcv = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114024);
          return 0;
        case 4: 
          localbsg.Tcw = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(114024);
          return 0;
        }
        localbsg.Tcx = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(114024);
        return 0;
      }
      AppMethodBeat.o(114024);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsg
 * JD-Core Version:    0.7.0.1
 */