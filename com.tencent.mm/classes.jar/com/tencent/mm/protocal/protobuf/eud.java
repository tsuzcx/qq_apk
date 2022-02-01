package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eud
  extends dyl
{
  public int UdZ;
  public String UvP;
  public String UvR;
  public String tol;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72597);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.tol != null) {
        paramVarArgs.f(2, this.tol);
      }
      if (this.UvP != null) {
        paramVarArgs.f(3, this.UvP);
      }
      if (this.UvR != null) {
        paramVarArgs.f(4, this.UvR);
      }
      paramVarArgs.aY(5, this.UdZ);
      AppMethodBeat.o(72597);
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
      if (this.tol != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.tol);
      }
      i = paramInt;
      if (this.UvP != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UvP);
      }
      paramInt = i;
      if (this.UvR != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UvR);
      }
      i = g.a.a.b.b.a.bM(5, this.UdZ);
      AppMethodBeat.o(72597);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72597);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eud localeud = (eud)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72597);
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
            localeud.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(72597);
          return 0;
        case 2: 
          localeud.tol = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72597);
          return 0;
        case 3: 
          localeud.UvP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72597);
          return 0;
        case 4: 
          localeud.UvR = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72597);
          return 0;
        }
        localeud.UdZ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(72597);
        return 0;
      }
      AppMethodBeat.o(72597);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eud
 * JD-Core Version:    0.7.0.1
 */