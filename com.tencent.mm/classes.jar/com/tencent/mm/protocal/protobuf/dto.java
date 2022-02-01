package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dto
  extends dyl
{
  public String Izj;
  public int Twy;
  public String jUb;
  public String jUc;
  public String jUd;
  public String jUe;
  public String jUf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152666);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jUb != null) {
        paramVarArgs.f(2, this.jUb);
      }
      if (this.jUc != null) {
        paramVarArgs.f(3, this.jUc);
      }
      if (this.jUd != null) {
        paramVarArgs.f(4, this.jUd);
      }
      if (this.jUe != null) {
        paramVarArgs.f(5, this.jUe);
      }
      if (this.jUf != null) {
        paramVarArgs.f(6, this.jUf);
      }
      paramVarArgs.aY(7, this.Twy);
      if (this.Izj != null) {
        paramVarArgs.f(8, this.Izj);
      }
      AppMethodBeat.o(152666);
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
      if (this.jUb != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.jUb);
      }
      i = paramInt;
      if (this.jUc != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.jUc);
      }
      paramInt = i;
      if (this.jUd != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.jUd);
      }
      i = paramInt;
      if (this.jUe != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.jUe);
      }
      paramInt = i;
      if (this.jUf != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.jUf);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.Twy);
      paramInt = i;
      if (this.Izj != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Izj);
      }
      AppMethodBeat.o(152666);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dto localdto = (dto)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152666);
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
            localdto.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(152666);
          return 0;
        case 2: 
          localdto.jUb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 3: 
          localdto.jUc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 4: 
          localdto.jUd = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 5: 
          localdto.jUe = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 6: 
          localdto.jUf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152666);
          return 0;
        case 7: 
          localdto.Twy = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152666);
          return 0;
        }
        localdto.Izj = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152666);
        return 0;
      }
      AppMethodBeat.o(152666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dto
 * JD-Core Version:    0.7.0.1
 */