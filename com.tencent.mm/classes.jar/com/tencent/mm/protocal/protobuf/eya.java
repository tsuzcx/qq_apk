package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eya
  extends dyl
{
  public boolean Uyl;
  public int jUj;
  public String lVG;
  public int rWs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123666);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lVG != null) {
        paramVarArgs.f(2, this.lVG);
      }
      paramVarArgs.aY(3, this.rWs);
      paramVarArgs.co(4, this.Uyl);
      paramVarArgs.aY(5, this.jUj);
      AppMethodBeat.o(123666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label484;
      }
    }
    label484:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lVG != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.lVG);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.rWs);
      int j = g.a.a.b.b.a.gL(4);
      int k = g.a.a.b.b.a.bM(5, this.jUj);
      AppMethodBeat.o(123666);
      return i + paramInt + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eya localeya = (eya)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123666);
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
            localeya.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(123666);
          return 0;
        case 2: 
          localeya.lVG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123666);
          return 0;
        case 3: 
          localeya.rWs = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123666);
          return 0;
        case 4: 
          localeya.Uyl = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(123666);
          return 0;
        }
        localeya.jUj = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(123666);
        return 0;
      }
      AppMethodBeat.o(123666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eya
 * JD-Core Version:    0.7.0.1
 */