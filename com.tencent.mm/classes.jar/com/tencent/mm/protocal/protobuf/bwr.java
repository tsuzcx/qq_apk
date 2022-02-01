package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwr
  extends dyl
{
  public int KlE;
  public long KlG;
  public int Tgu;
  public String jDL;
  public String jDM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125732);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.KlG);
      paramVarArgs.aY(3, this.Tgu);
      if (this.jDM != null) {
        paramVarArgs.f(4, this.jDM);
      }
      if (this.jDL != null) {
        paramVarArgs.f(5, this.jDL);
      }
      paramVarArgs.aY(6, this.KlE);
      AppMethodBeat.o(125732);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label540;
      }
    }
    label540:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.KlG) + g.a.a.b.b.a.bM(3, this.Tgu);
      paramInt = i;
      if (this.jDM != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.jDM);
      }
      i = paramInt;
      if (this.jDL != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.jDL);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.KlE);
      AppMethodBeat.o(125732);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125732);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bwr localbwr = (bwr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125732);
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
            localbwr.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(125732);
          return 0;
        case 2: 
          localbwr.KlG = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(125732);
          return 0;
        case 3: 
          localbwr.Tgu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125732);
          return 0;
        case 4: 
          localbwr.jDM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125732);
          return 0;
        case 5: 
          localbwr.jDL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125732);
          return 0;
        }
        localbwr.KlE = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(125732);
        return 0;
      }
      AppMethodBeat.o(125732);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwr
 * JD-Core Version:    0.7.0.1
 */