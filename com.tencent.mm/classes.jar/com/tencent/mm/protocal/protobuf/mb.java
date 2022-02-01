package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mb
  extends dyl
{
  public String RRD;
  public String RRE;
  public long RRF;
  public String mac;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82394);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RRD != null) {
        paramVarArgs.f(2, this.RRD);
      }
      if (this.RRE != null) {
        paramVarArgs.f(3, this.RRE);
      }
      if (this.mac != null) {
        paramVarArgs.f(4, this.mac);
      }
      paramVarArgs.bm(5, this.RRF);
      AppMethodBeat.o(82394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label512;
      }
    }
    label512:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RRD != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RRD);
      }
      i = paramInt;
      if (this.RRE != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RRE);
      }
      paramInt = i;
      if (this.mac != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.mac);
      }
      i = g.a.a.b.b.a.p(5, this.RRF);
      AppMethodBeat.o(82394);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        mb localmb = (mb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82394);
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
            localmb.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(82394);
          return 0;
        case 2: 
          localmb.RRD = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82394);
          return 0;
        case 3: 
          localmb.RRE = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82394);
          return 0;
        case 4: 
          localmb.mac = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82394);
          return 0;
        }
        localmb.RRF = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(82394);
        return 0;
      }
      AppMethodBeat.o(82394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mb
 * JD-Core Version:    0.7.0.1
 */