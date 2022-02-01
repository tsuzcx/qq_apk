package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtv
  extends com.tencent.mm.bx.a
{
  public fmp YCT;
  public String YMe;
  public LinkedList<fmp> Zdm;
  public String aaZt;
  
  public dtv()
  {
    AppMethodBeat.i(91553);
    this.Zdm = new LinkedList();
    AppMethodBeat.o(91553);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91554);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YCT != null)
      {
        paramVarArgs.qD(1, this.YCT.computeSize());
        this.YCT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Zdm);
      if (this.YMe != null) {
        paramVarArgs.g(3, this.YMe);
      }
      if (this.aaZt != null) {
        paramVarArgs.g(4, this.aaZt);
      }
      AppMethodBeat.o(91554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YCT == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = i.a.a.a.qC(1, this.YCT.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.Zdm);
      paramInt = i;
      if (this.YMe != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YMe);
      }
      i = paramInt;
      if (this.aaZt != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aaZt);
      }
      AppMethodBeat.o(91554);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zdm.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dtv localdtv = (dtv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        fmp localfmp;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91554);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localfmp = new fmp();
            if ((localObject != null) && (localObject.length > 0)) {
              localfmp.parseFrom((byte[])localObject);
            }
            localdtv.YCT = localfmp;
            paramInt += 1;
          }
          AppMethodBeat.o(91554);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localfmp = new fmp();
            if ((localObject != null) && (localObject.length > 0)) {
              localfmp.parseFrom((byte[])localObject);
            }
            localdtv.Zdm.add(localfmp);
            paramInt += 1;
          }
          AppMethodBeat.o(91554);
          return 0;
        case 3: 
          localdtv.YMe = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91554);
          return 0;
        }
        localdtv.aaZt = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91554);
        return 0;
      }
      AppMethodBeat.o(91554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtv
 * JD-Core Version:    0.7.0.1
 */