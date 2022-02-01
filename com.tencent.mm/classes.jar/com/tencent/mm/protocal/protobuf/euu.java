package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class euu
  extends dyl
{
  public cmm Uww;
  public LinkedList<ef> Uwx;
  public String link;
  public int scene;
  
  public euu()
  {
    AppMethodBeat.i(152712);
    this.Uwx = new LinkedList();
    AppMethodBeat.o(152712);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152713);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.link != null) {
        paramVarArgs.f(2, this.link);
      }
      paramVarArgs.aY(3, this.scene);
      if (this.Uww != null)
      {
        paramVarArgs.oE(4, this.Uww.computeSize());
        this.Uww.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.Uwx);
      AppMethodBeat.o(152713);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label644;
      }
    }
    label644:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.link != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.link);
      }
      i += g.a.a.b.b.a.bM(3, this.scene);
      paramInt = i;
      if (this.Uww != null) {
        paramInt = i + g.a.a.a.oD(4, this.Uww.computeSize());
      }
      i = g.a.a.a.c(5, 8, this.Uwx);
      AppMethodBeat.o(152713);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Uwx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152713);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        euu localeuu = (euu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152713);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localeuu.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152713);
          return 0;
        case 2: 
          localeuu.link = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152713);
          return 0;
        case 3: 
          localeuu.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152713);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cmm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cmm)localObject2).parseFrom((byte[])localObject1);
            }
            localeuu.Uww = ((cmm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152713);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ef();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ef)localObject2).parseFrom((byte[])localObject1);
          }
          localeuu.Uwx.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152713);
        return 0;
      }
      AppMethodBeat.o(152713);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.euu
 * JD-Core Version:    0.7.0.1
 */