package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class avp
  extends ckq
{
  public int CCB;
  public bld Dbk;
  public String Dop;
  public SKBuiltinBuffer_t Dva;
  public int Dvb;
  public int Dvc;
  public LinkedList<cam> Dvd;
  public int Dve;
  public int Scene;
  
  public avp()
  {
    AppMethodBeat.i(32249);
    this.Dvd = new LinkedList();
    AppMethodBeat.o(32249);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32250);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dbk == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(32250);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CCB);
      paramVarArgs.aR(3, this.Scene);
      if (this.Dva != null)
      {
        paramVarArgs.kX(4, this.Dva.computeSize());
        this.Dva.writeFields(paramVarArgs);
      }
      if (this.Dbk != null)
      {
        paramVarArgs.kX(5, this.Dbk.computeSize());
        this.Dbk.writeFields(paramVarArgs);
      }
      if (this.Dop != null) {
        paramVarArgs.d(6, this.Dop);
      }
      paramVarArgs.aR(7, this.Dvb);
      paramVarArgs.aR(8, this.Dvc);
      paramVarArgs.e(11, 8, this.Dvd);
      paramVarArgs.aR(12, this.Dve);
      AppMethodBeat.o(32250);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1126;
      }
    }
    label1126:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CCB) + f.a.a.b.b.a.bA(3, this.Scene);
      paramInt = i;
      if (this.Dva != null) {
        paramInt = i + f.a.a.a.kW(4, this.Dva.computeSize());
      }
      i = paramInt;
      if (this.Dbk != null) {
        i = paramInt + f.a.a.a.kW(5, this.Dbk.computeSize());
      }
      paramInt = i;
      if (this.Dop != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Dop);
      }
      i = f.a.a.b.b.a.bA(7, this.Dvb);
      int j = f.a.a.b.b.a.bA(8, this.Dvc);
      int k = f.a.a.a.c(11, 8, this.Dvd);
      int m = f.a.a.b.b.a.bA(12, this.Dve);
      AppMethodBeat.o(32250);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dvd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Dbk == null)
        {
          paramVarArgs = new b("Not all required fields were included: Loc");
          AppMethodBeat.o(32250);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32250);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avp localavp = (avp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(32250);
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
            localavp.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 2: 
          localavp.CCB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32250);
          return 0;
        case 3: 
          localavp.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32250);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavp.Dva = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bld();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bld)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavp.Dbk = ((bld)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        case 6: 
          localavp.Dop = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32250);
          return 0;
        case 7: 
          localavp.Dvb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32250);
          return 0;
        case 8: 
          localavp.Dvc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32250);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cam();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cam)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavp.Dvd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32250);
          return 0;
        }
        localavp.Dve = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32250);
        return 0;
      }
      AppMethodBeat.o(32250);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avp
 * JD-Core Version:    0.7.0.1
 */