package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class buo
  extends dyl
{
  public int CPw;
  public int TeG;
  public aho TeH;
  public LinkedList<alk> TeI;
  public int TeJ;
  public String TeK;
  
  public buo()
  {
    AppMethodBeat.i(256137);
    this.TeI = new LinkedList();
    AppMethodBeat.o(256137);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256142);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TeH == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceType");
        AppMethodBeat.o(256142);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TeG);
      paramVarArgs.aY(3, this.CPw);
      if (this.TeH != null)
      {
        paramVarArgs.oE(4, this.TeH.computeSize());
        this.TeH.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.TeI);
      paramVarArgs.aY(6, this.TeJ);
      if (this.TeK != null) {
        paramVarArgs.f(7, this.TeK);
      }
      AppMethodBeat.o(256142);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label780;
      }
    }
    label780:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TeG) + g.a.a.b.b.a.bM(3, this.CPw);
      paramInt = i;
      if (this.TeH != null) {
        paramInt = i + g.a.a.a.oD(4, this.TeH.computeSize());
      }
      i = paramInt + g.a.a.a.c(5, 8, this.TeI) + g.a.a.b.b.a.bM(6, this.TeJ);
      paramInt = i;
      if (this.TeK != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TeK);
      }
      AppMethodBeat.o(256142);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TeI.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TeH == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceType");
          AppMethodBeat.o(256142);
          throw paramVarArgs;
        }
        AppMethodBeat.o(256142);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        buo localbuo = (buo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(256142);
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
            localbuo.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(256142);
          return 0;
        case 2: 
          localbuo.TeG = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(256142);
          return 0;
        case 3: 
          localbuo.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(256142);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aho();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aho)localObject2).parseFrom((byte[])localObject1);
            }
            localbuo.TeH = ((aho)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(256142);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new alk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((alk)localObject2).parseFrom((byte[])localObject1);
            }
            localbuo.TeI.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(256142);
          return 0;
        case 6: 
          localbuo.TeJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(256142);
          return 0;
        }
        localbuo.TeK = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(256142);
        return 0;
      }
      AppMethodBeat.o(256142);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buo
 * JD-Core Version:    0.7.0.1
 */