package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsu
  extends dop
{
  public String KCy;
  public String dFd;
  public String dHx;
  public String wOK;
  public String wOL;
  public String wOM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32262);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dFd != null) {
        paramVarArgs.e(2, this.dFd);
      }
      if (this.wOK != null) {
        paramVarArgs.e(3, this.wOK);
      }
      if (this.wOL != null) {
        paramVarArgs.e(4, this.wOL);
      }
      if (this.wOM != null) {
        paramVarArgs.e(5, this.wOM);
      }
      if (this.dHx != null) {
        paramVarArgs.e(6, this.dHx);
      }
      if (this.KCy != null) {
        paramVarArgs.e(7, this.KCy);
      }
      AppMethodBeat.o(32262);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label687;
      }
    }
    label687:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dFd != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dFd);
      }
      i = paramInt;
      if (this.wOK != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.wOK);
      }
      paramInt = i;
      if (this.wOL != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.wOL);
      }
      i = paramInt;
      if (this.wOM != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.wOM);
      }
      paramInt = i;
      if (this.dHx != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.dHx);
      }
      i = paramInt;
      if (this.KCy != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.KCy);
      }
      AppMethodBeat.o(32262);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32262);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bsu localbsu = (bsu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32262);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbsu.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32262);
          return 0;
        case 2: 
          localbsu.dFd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32262);
          return 0;
        case 3: 
          localbsu.wOK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32262);
          return 0;
        case 4: 
          localbsu.wOL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32262);
          return 0;
        case 5: 
          localbsu.wOM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32262);
          return 0;
        case 6: 
          localbsu.dHx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32262);
          return 0;
        }
        localbsu.KCy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32262);
        return 0;
      }
      AppMethodBeat.o(32262);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsu
 * JD-Core Version:    0.7.0.1
 */