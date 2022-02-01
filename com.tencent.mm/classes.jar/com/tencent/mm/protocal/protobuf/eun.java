package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eun
  extends dyl
{
  public String InV;
  public String InW;
  public String RDD;
  public String UvJ;
  public String UvK;
  public String Uwb;
  public int amount;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72609);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RDD != null) {
        paramVarArgs.f(2, this.RDD);
      }
      if (this.InV != null) {
        paramVarArgs.f(3, this.InV);
      }
      if (this.UvJ != null) {
        paramVarArgs.f(4, this.UvJ);
      }
      if (this.UvK != null) {
        paramVarArgs.f(5, this.UvK);
      }
      paramVarArgs.aY(6, this.amount);
      if (this.Uwb != null) {
        paramVarArgs.f(7, this.Uwb);
      }
      if (this.InW != null) {
        paramVarArgs.f(8, this.InW);
      }
      AppMethodBeat.o(72609);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label700;
      }
    }
    label700:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RDD != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RDD);
      }
      i = paramInt;
      if (this.InV != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.InV);
      }
      paramInt = i;
      if (this.UvJ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UvJ);
      }
      i = paramInt;
      if (this.UvK != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UvK);
      }
      i += g.a.a.b.b.a.bM(6, this.amount);
      paramInt = i;
      if (this.Uwb != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Uwb);
      }
      i = paramInt;
      if (this.InW != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.InW);
      }
      AppMethodBeat.o(72609);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72609);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eun localeun = (eun)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72609);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localeun.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(72609);
          return 0;
        case 2: 
          localeun.RDD = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 3: 
          localeun.InV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 4: 
          localeun.UvJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 5: 
          localeun.UvK = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 6: 
          localeun.amount = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72609);
          return 0;
        case 7: 
          localeun.Uwb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72609);
          return 0;
        }
        localeun.InW = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72609);
        return 0;
      }
      AppMethodBeat.o(72609);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eun
 * JD-Core Version:    0.7.0.1
 */