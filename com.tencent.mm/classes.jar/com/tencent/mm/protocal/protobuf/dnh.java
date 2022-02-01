package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnh
  extends dyy
{
  public String REI;
  public String REJ;
  public String TUt;
  public String TUu;
  public String TUv;
  public String TUw;
  public String background_color;
  public String content;
  public int status;
  public String tpM;
  public boolean tqv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114055);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.REI != null) {
        paramVarArgs.f(2, this.REI);
      }
      if (this.REJ != null) {
        paramVarArgs.f(3, this.REJ);
      }
      paramVarArgs.aY(4, this.status);
      if (this.content != null) {
        paramVarArgs.f(5, this.content);
      }
      if (this.tpM != null) {
        paramVarArgs.f(6, this.tpM);
      }
      if (this.background_color != null) {
        paramVarArgs.f(7, this.background_color);
      }
      paramVarArgs.co(8, this.tqv);
      if (this.TUt != null) {
        paramVarArgs.f(9, this.TUt);
      }
      if (this.TUu != null) {
        paramVarArgs.f(10, this.TUu);
      }
      if (this.TUv != null) {
        paramVarArgs.f(11, this.TUv);
      }
      if (this.TUw != null) {
        paramVarArgs.f(12, this.TUw);
      }
      AppMethodBeat.o(114055);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label928;
      }
    }
    label928:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.REI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.REI);
      }
      i = paramInt;
      if (this.REJ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.REJ);
      }
      i += g.a.a.b.b.a.bM(4, this.status);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.content);
      }
      i = paramInt;
      if (this.tpM != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.tpM);
      }
      paramInt = i;
      if (this.background_color != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.background_color);
      }
      i = paramInt + (g.a.a.b.b.a.gL(8) + 1);
      paramInt = i;
      if (this.TUt != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.TUt);
      }
      i = paramInt;
      if (this.TUu != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.TUu);
      }
      paramInt = i;
      if (this.TUv != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.TUv);
      }
      i = paramInt;
      if (this.TUw != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.TUw);
      }
      AppMethodBeat.o(114055);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(114055);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dnh localdnh = (dnh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114055);
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
            localdnh.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(114055);
          return 0;
        case 2: 
          localdnh.REI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 3: 
          localdnh.REJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 4: 
          localdnh.status = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(114055);
          return 0;
        case 5: 
          localdnh.content = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 6: 
          localdnh.tpM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 7: 
          localdnh.background_color = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 8: 
          localdnh.tqv = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(114055);
          return 0;
        case 9: 
          localdnh.TUt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 10: 
          localdnh.TUu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 11: 
          localdnh.TUv = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114055);
          return 0;
        }
        localdnh.TUw = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(114055);
        return 0;
      }
      AppMethodBeat.o(114055);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnh
 * JD-Core Version:    0.7.0.1
 */