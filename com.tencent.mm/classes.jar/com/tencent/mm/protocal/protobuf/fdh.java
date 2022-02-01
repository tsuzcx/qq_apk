package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fdh
  extends dyl
{
  public int RNa;
  public long Svv;
  public long TVZ;
  public int TWa;
  public String UDq;
  public long Urf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125494);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TWa);
      paramVarArgs.bm(3, this.Urf);
      paramVarArgs.bm(4, this.Svv);
      if (this.UDq != null) {
        paramVarArgs.f(5, this.UDq);
      }
      paramVarArgs.bm(6, this.TVZ);
      paramVarArgs.aY(7, this.RNa);
      AppMethodBeat.o(125494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label572;
      }
    }
    label572:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TWa) + g.a.a.b.b.a.p(3, this.Urf) + g.a.a.b.b.a.p(4, this.Svv);
      paramInt = i;
      if (this.UDq != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.UDq);
      }
      i = g.a.a.b.b.a.p(6, this.TVZ);
      int j = g.a.a.b.b.a.bM(7, this.RNa);
      AppMethodBeat.o(125494);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125494);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fdh localfdh = (fdh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125494);
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
            localfdh.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(125494);
          return 0;
        case 2: 
          localfdh.TWa = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125494);
          return 0;
        case 3: 
          localfdh.Urf = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(125494);
          return 0;
        case 4: 
          localfdh.Svv = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(125494);
          return 0;
        case 5: 
          localfdh.UDq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125494);
          return 0;
        case 6: 
          localfdh.TVZ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(125494);
          return 0;
        }
        localfdh.RNa = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(125494);
        return 0;
      }
      AppMethodBeat.o(125494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdh
 * JD-Core Version:    0.7.0.1
 */