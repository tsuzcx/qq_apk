package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dni
  extends erp
{
  public long ABg;
  public dnf aaUG;
  public String aaUH;
  public String aahV;
  public int scene;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258529);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.aaUG != null)
      {
        paramVarArgs.qD(2, this.aaUG.computeSize());
        this.aaUG.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(3, this.ABg);
      if (this.username != null) {
        paramVarArgs.g(4, this.username);
      }
      if (this.aahV != null) {
        paramVarArgs.g(5, this.aahV);
      }
      if (this.aaUH != null) {
        paramVarArgs.g(6, this.aaUH);
      }
      paramVarArgs.bS(7, this.scene);
      AppMethodBeat.o(258529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaUG != null) {
        i = paramInt + i.a.a.a.qC(2, this.aaUG.computeSize());
      }
      i += i.a.a.b.b.a.q(3, this.ABg);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.username);
      }
      i = paramInt;
      if (this.aahV != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aahV);
      }
      paramInt = i;
      if (this.aaUH != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaUH);
      }
      i = i.a.a.b.b.a.cJ(7, this.scene);
      AppMethodBeat.o(258529);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258529);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dni localdni = (dni)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258529);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localdni.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258529);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dnf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dnf)localObject2).parseFrom((byte[])localObject1);
            }
            localdni.aaUG = ((dnf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258529);
          return 0;
        case 3: 
          localdni.ABg = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258529);
          return 0;
        case 4: 
          localdni.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258529);
          return 0;
        case 5: 
          localdni.aahV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258529);
          return 0;
        case 6: 
          localdni.aaUH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258529);
          return 0;
        }
        localdni.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258529);
        return 0;
      }
      AppMethodBeat.o(258529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dni
 * JD-Core Version:    0.7.0.1
 */