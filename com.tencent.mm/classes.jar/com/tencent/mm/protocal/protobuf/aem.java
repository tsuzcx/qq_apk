package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aem
  extends dyl
{
  public String EtJ;
  public String SkU;
  public String SkY;
  public String SqY;
  public long SqZ;
  public int qJt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72466);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SqY != null) {
        paramVarArgs.f(2, this.SqY);
      }
      paramVarArgs.bm(3, this.SqZ);
      if (this.SkU != null) {
        paramVarArgs.f(4, this.SkU);
      }
      if (this.SkY != null) {
        paramVarArgs.f(5, this.SkY);
      }
      paramVarArgs.aY(6, this.qJt);
      if (this.EtJ != null) {
        paramVarArgs.f(7, this.EtJ);
      }
      AppMethodBeat.o(72466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label620;
      }
    }
    label620:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SqY != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SqY);
      }
      i += g.a.a.b.b.a.p(3, this.SqZ);
      paramInt = i;
      if (this.SkU != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SkU);
      }
      i = paramInt;
      if (this.SkY != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SkY);
      }
      i += g.a.a.b.b.a.bM(6, this.qJt);
      paramInt = i;
      if (this.EtJ != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.EtJ);
      }
      AppMethodBeat.o(72466);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72466);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        aem localaem = (aem)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72466);
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
            localaem.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(72466);
          return 0;
        case 2: 
          localaem.SqY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72466);
          return 0;
        case 3: 
          localaem.SqZ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(72466);
          return 0;
        case 4: 
          localaem.SkU = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72466);
          return 0;
        case 5: 
          localaem.SkY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72466);
          return 0;
        case 6: 
          localaem.qJt = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72466);
          return 0;
        }
        localaem.EtJ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72466);
        return 0;
      }
      AppMethodBeat.o(72466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aem
 * JD-Core Version:    0.7.0.1
 */