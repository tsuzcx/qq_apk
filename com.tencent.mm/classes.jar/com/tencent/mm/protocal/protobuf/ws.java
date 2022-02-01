package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ws
  extends cvc
{
  public int FVV;
  public LinkedList<cwt> FVW;
  public String FVX;
  public String FVY;
  public int Scene;
  public String gsT;
  public int tRT;
  public String uki;
  public String ukw;
  
  public ws()
  {
    AppMethodBeat.i(124468);
    this.FVW = new LinkedList();
    AppMethodBeat.o(124468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124469);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.tRT);
      if (this.uki != null) {
        paramVarArgs.d(3, this.uki);
      }
      if (this.ukw != null) {
        paramVarArgs.d(4, this.ukw);
      }
      if (this.gsT != null) {
        paramVarArgs.d(5, this.gsT);
      }
      paramVarArgs.aS(6, this.FVV);
      paramVarArgs.e(7, 8, this.FVW);
      if (this.FVX != null) {
        paramVarArgs.d(8, this.FVX);
      }
      if (this.FVY != null) {
        paramVarArgs.d(9, this.FVY);
      }
      paramVarArgs.aS(10, this.Scene);
      AppMethodBeat.o(124469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label890;
      }
    }
    label890:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.tRT);
      paramInt = i;
      if (this.uki != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.uki);
      }
      i = paramInt;
      if (this.ukw != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.ukw);
      }
      paramInt = i;
      if (this.gsT != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.gsT);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.FVV) + f.a.a.a.c(7, 8, this.FVW);
      paramInt = i;
      if (this.FVX != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FVX);
      }
      i = paramInt;
      if (this.FVY != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FVY);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.Scene);
      AppMethodBeat.o(124469);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FVW.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ws localws = (ws)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124469);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localws.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124469);
          return 0;
        case 2: 
          localws.tRT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124469);
          return 0;
        case 3: 
          localws.uki = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 4: 
          localws.ukw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 5: 
          localws.gsT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 6: 
          localws.FVV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124469);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localws.FVW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124469);
          return 0;
        case 8: 
          localws.FVX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 9: 
          localws.FVY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124469);
          return 0;
        }
        localws.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(124469);
        return 0;
      }
      AppMethodBeat.o(124469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ws
 * JD-Core Version:    0.7.0.1
 */