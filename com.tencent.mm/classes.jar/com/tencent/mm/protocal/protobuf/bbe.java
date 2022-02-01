package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bbe
  extends cvc
{
  public String FEW;
  public String FWx;
  public cis Gxf;
  public int Gyk;
  public String Gyl;
  public b Gym;
  public boolean Gyn;
  public String action_data;
  public String person_id;
  public String pkf;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104371);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.person_id != null) {
        paramVarArgs.d(2, this.person_id);
      }
      if (this.action_data != null) {
        paramVarArgs.d(3, this.action_data);
      }
      paramVarArgs.aS(4, this.Gyk);
      if (this.Gyl != null) {
        paramVarArgs.d(5, this.Gyl);
      }
      if (this.FEW != null) {
        paramVarArgs.d(6, this.FEW);
      }
      paramVarArgs.aS(7, this.scene);
      if (this.FWx != null) {
        paramVarArgs.d(8, this.FWx);
      }
      if (this.pkf != null) {
        paramVarArgs.d(9, this.pkf);
      }
      if (this.Gxf != null)
      {
        paramVarArgs.lC(10, this.Gxf.computeSize());
        this.Gxf.writeFields(paramVarArgs);
      }
      if (this.Gym != null) {
        paramVarArgs.c(11, this.Gym);
      }
      paramVarArgs.bt(12, this.Gyn);
      AppMethodBeat.o(104371);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1026;
      }
    }
    label1026:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.person_id != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.person_id);
      }
      i = paramInt;
      if (this.action_data != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.action_data);
      }
      i += f.a.a.b.b.a.bz(4, this.Gyk);
      paramInt = i;
      if (this.Gyl != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Gyl);
      }
      i = paramInt;
      if (this.FEW != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FEW);
      }
      i += f.a.a.b.b.a.bz(7, this.scene);
      paramInt = i;
      if (this.FWx != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FWx);
      }
      i = paramInt;
      if (this.pkf != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.pkf);
      }
      paramInt = i;
      if (this.Gxf != null) {
        paramInt = i + f.a.a.a.lB(10, this.Gxf.computeSize());
      }
      i = paramInt;
      if (this.Gym != null) {
        i = paramInt + f.a.a.b.b.a.b(11, this.Gym);
      }
      paramInt = f.a.a.b.b.a.alV(12);
      AppMethodBeat.o(104371);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(104371);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbe localbbe = (bbe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104371);
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
            localbbe.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104371);
          return 0;
        case 2: 
          localbbe.person_id = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 3: 
          localbbe.action_data = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 4: 
          localbbe.Gyk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(104371);
          return 0;
        case 5: 
          localbbe.Gyl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 6: 
          localbbe.FEW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 7: 
          localbbe.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(104371);
          return 0;
        case 8: 
          localbbe.FWx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 9: 
          localbbe.pkf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cis();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cis)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbe.Gxf = ((cis)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104371);
          return 0;
        case 11: 
          localbbe.Gym = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(104371);
          return 0;
        }
        localbbe.Gyn = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(104371);
        return 0;
      }
      AppMethodBeat.o(104371);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbe
 * JD-Core Version:    0.7.0.1
 */