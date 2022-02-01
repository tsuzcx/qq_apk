package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bly
  extends dyl
{
  public int SWZ;
  public int SXa;
  public ja Slc;
  public String Sld;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91468);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Slc != null)
      {
        paramVarArgs.oE(2, this.Slc.computeSize());
        this.Slc.writeFields(paramVarArgs);
      }
      if (this.Sld != null) {
        paramVarArgs.f(3, this.Sld);
      }
      paramVarArgs.aY(4, this.SWZ);
      paramVarArgs.aY(5, this.SXa);
      AppMethodBeat.o(91468);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label570;
      }
    }
    label570:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Slc != null) {
        paramInt = i + g.a.a.a.oD(2, this.Slc.computeSize());
      }
      i = paramInt;
      if (this.Sld != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Sld);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.SWZ);
      int j = g.a.a.b.b.a.bM(5, this.SXa);
      AppMethodBeat.o(91468);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91468);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bly localbly = (bly)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91468);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localbly.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91468);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ja();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ja)localObject2).parseFrom((byte[])localObject1);
            }
            localbly.Slc = ((ja)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91468);
          return 0;
        case 3: 
          localbly.Sld = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91468);
          return 0;
        case 4: 
          localbly.SWZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91468);
          return 0;
        }
        localbly.SXa = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91468);
        return 0;
      }
      AppMethodBeat.o(91468);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bly
 * JD-Core Version:    0.7.0.1
 */