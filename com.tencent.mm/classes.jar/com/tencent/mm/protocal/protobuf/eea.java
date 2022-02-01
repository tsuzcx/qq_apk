package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eea
  extends dyl
{
  public int CPw;
  public String RJQ;
  public String TWw;
  public String Uia;
  public String Uib;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(186710);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.TWw != null) {
        paramVarArgs.f(2, this.TWw);
      }
      if (this.Uia != null) {
        paramVarArgs.f(3, this.Uia);
      }
      if (this.Uib != null) {
        paramVarArgs.f(4, this.Uib);
      }
      if (this.RJQ != null) {
        paramVarArgs.f(5, this.RJQ);
      }
      paramVarArgs.aY(6, this.CPw);
      AppMethodBeat.o(186710);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label576;
      }
    }
    label576:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TWw != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TWw);
      }
      i = paramInt;
      if (this.Uia != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Uia);
      }
      paramInt = i;
      if (this.Uib != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Uib);
      }
      i = paramInt;
      if (this.RJQ != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RJQ);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.CPw);
      AppMethodBeat.o(186710);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(186710);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eea localeea = (eea)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(186710);
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
            localeea.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(186710);
          return 0;
        case 2: 
          localeea.TWw = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(186710);
          return 0;
        case 3: 
          localeea.Uia = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(186710);
          return 0;
        case 4: 
          localeea.Uib = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(186710);
          return 0;
        case 5: 
          localeea.RJQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(186710);
          return 0;
        }
        localeea.CPw = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(186710);
        return 0;
      }
      AppMethodBeat.o(186710);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eea
 * JD-Core Version:    0.7.0.1
 */