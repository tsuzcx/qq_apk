package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsl
  extends cvc
{
  public String GdZ;
  public String Gea;
  public String Geb;
  public boolean HFj;
  public LinkedList<String> HFk;
  public String HFl;
  public boolean HFo;
  public String MD5;
  public int Scene;
  
  public dsl()
  {
    AppMethodBeat.i(104842);
    this.HFk = new LinkedList();
    AppMethodBeat.o(104842);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104843);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(2, this.MD5);
      }
      paramVarArgs.bt(3, this.HFo);
      paramVarArgs.bt(4, this.HFj);
      paramVarArgs.e(5, 1, this.HFk);
      if (this.GdZ != null) {
        paramVarArgs.d(6, this.GdZ);
      }
      if (this.HFl != null) {
        paramVarArgs.d(7, this.HFl);
      }
      if (this.Geb != null) {
        paramVarArgs.d(8, this.Geb);
      }
      if (this.Gea != null) {
        paramVarArgs.d(9, this.Gea);
      }
      paramVarArgs.aS(10, this.Scene);
      AppMethodBeat.o(104843);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.MD5);
      }
      i = i + f.a.a.b.b.a.alV(3) + f.a.a.b.b.a.alV(4) + f.a.a.a.c(5, 1, this.HFk);
      paramInt = i;
      if (this.GdZ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GdZ);
      }
      i = paramInt;
      if (this.HFl != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HFl);
      }
      paramInt = i;
      if (this.Geb != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Geb);
      }
      i = paramInt;
      if (this.Gea != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Gea);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.Scene);
      AppMethodBeat.o(104843);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HFk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(104843);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsl localdsl = (dsl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104843);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsl.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104843);
          return 0;
        case 2: 
          localdsl.MD5 = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 3: 
          localdsl.HFo = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(104843);
          return 0;
        case 4: 
          localdsl.HFj = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(104843);
          return 0;
        case 5: 
          localdsl.HFk.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(104843);
          return 0;
        case 6: 
          localdsl.GdZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 7: 
          localdsl.HFl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 8: 
          localdsl.Geb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 9: 
          localdsl.Gea = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104843);
          return 0;
        }
        localdsl.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(104843);
        return 0;
      }
      AppMethodBeat.o(104843);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsl
 * JD-Core Version:    0.7.0.1
 */