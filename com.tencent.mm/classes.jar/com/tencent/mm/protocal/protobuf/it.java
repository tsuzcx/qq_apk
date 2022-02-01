package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class it
  extends com.tencent.mm.bx.a
{
  public int YKE;
  public egc YKF;
  public String appid;
  public String token;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153260);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      paramVarArgs.bS(2, this.YKE);
      if (this.YKF != null)
      {
        paramVarArgs.qD(3, this.YKF.computeSize());
        this.YKF.writeFields(paramVarArgs);
      }
      if (this.token != null) {
        paramVarArgs.g(4, this.token);
      }
      if (this.appid != null) {
        paramVarArgs.g(5, this.appid);
      }
      AppMethodBeat.o(153260);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label508;
      }
    }
    label508:
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YKE);
      paramInt = i;
      if (this.YKF != null) {
        paramInt = i + i.a.a.a.qC(3, this.YKF.computeSize());
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.token);
      }
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.appid);
      }
      AppMethodBeat.o(153260);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153260);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        it localit = (it)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153260);
          return -1;
        case 1: 
          localit.username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153260);
          return 0;
        case 2: 
          localit.YKE = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(153260);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            egc localegc = new egc();
            if ((localObject != null) && (localObject.length > 0)) {
              localegc.parseFrom((byte[])localObject);
            }
            localit.YKF = localegc;
            paramInt += 1;
          }
          AppMethodBeat.o(153260);
          return 0;
        case 4: 
          localit.token = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153260);
          return 0;
        }
        localit.appid = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(153260);
        return 0;
      }
      AppMethodBeat.o(153260);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.it
 * JD-Core Version:    0.7.0.1
 */