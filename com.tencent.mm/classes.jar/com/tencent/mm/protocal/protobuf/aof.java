package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aof
  extends ckq
{
  public int CCe;
  public int CEJ;
  public int CzZ;
  public int Dpw;
  public String Dpx;
  public LinkedList<aoe> Dpy;
  public LinkedList<b> Dpz;
  public int Scene;
  public String nlG;
  
  public aof()
  {
    AppMethodBeat.i(152547);
    this.Dpy = new LinkedList();
    this.Dpz = new LinkedList();
    AppMethodBeat.o(152547);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152548);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CEJ);
      paramVarArgs.aR(3, this.Scene);
      paramVarArgs.aR(4, this.CCe);
      paramVarArgs.aR(5, this.Dpw);
      if (this.nlG != null) {
        paramVarArgs.d(6, this.nlG);
      }
      if (this.Dpx != null) {
        paramVarArgs.d(7, this.Dpx);
      }
      paramVarArgs.aR(8, this.CzZ);
      paramVarArgs.e(9, 8, this.Dpy);
      paramVarArgs.e(10, 6, this.Dpz);
      AppMethodBeat.o(152548);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label858;
      }
    }
    label858:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CEJ) + f.a.a.b.b.a.bA(3, this.Scene) + f.a.a.b.b.a.bA(4, this.CCe) + f.a.a.b.b.a.bA(5, this.Dpw);
      paramInt = i;
      if (this.nlG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.nlG);
      }
      i = paramInt;
      if (this.Dpx != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Dpx);
      }
      paramInt = f.a.a.b.b.a.bA(8, this.CzZ);
      int j = f.a.a.a.c(9, 8, this.Dpy);
      int k = f.a.a.a.c(10, 6, this.Dpz);
      AppMethodBeat.o(152548);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dpy.clear();
        this.Dpz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152548);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aof localaof = (aof)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152548);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaof.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152548);
          return 0;
        case 2: 
          localaof.CEJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152548);
          return 0;
        case 3: 
          localaof.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152548);
          return 0;
        case 4: 
          localaof.CCe = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152548);
          return 0;
        case 5: 
          localaof.Dpw = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152548);
          return 0;
        case 6: 
          localaof.nlG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152548);
          return 0;
        case 7: 
          localaof.Dpx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152548);
          return 0;
        case 8: 
          localaof.CzZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152548);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aoe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aoe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaof.Dpy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152548);
          return 0;
        }
        localaof.Dpz.add(((f.a.a.a.a)localObject1).KhF.fMu());
        AppMethodBeat.o(152548);
        return 0;
      }
      AppMethodBeat.o(152548);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aof
 * JD-Core Version:    0.7.0.1
 */