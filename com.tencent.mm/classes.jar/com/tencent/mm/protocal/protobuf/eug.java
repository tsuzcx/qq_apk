package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eug
  extends dyy
{
  public boolean OAd;
  public String OzR;
  public boolean tpu;
  public int tqa;
  public String tqb;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72601);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      paramVarArgs.co(4, this.tpu);
      paramVarArgs.co(5, this.OAd);
      if (this.OzR != null) {
        paramVarArgs.f(6, this.OzR);
      }
      if (this.wording != null) {
        paramVarArgs.f(7, this.wording);
      }
      AppMethodBeat.o(72601);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label600;
      }
    }
    label600:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt + (g.a.a.b.b.a.gL(4) + 1) + (g.a.a.b.b.a.gL(5) + 1);
      paramInt = i;
      if (this.OzR != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.OzR);
      }
      i = paramInt;
      if (this.wording != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.wording);
      }
      AppMethodBeat.o(72601);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72601);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eug localeug = (eug)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72601);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localeug.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(72601);
          return 0;
        case 2: 
          localeug.tqa = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72601);
          return 0;
        case 3: 
          localeug.tqb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72601);
          return 0;
        case 4: 
          localeug.tpu = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(72601);
          return 0;
        case 5: 
          localeug.OAd = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(72601);
          return 0;
        case 6: 
          localeug.OzR = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72601);
          return 0;
        }
        localeug.wording = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72601);
        return 0;
      }
      AppMethodBeat.o(72601);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eug
 * JD-Core Version:    0.7.0.1
 */