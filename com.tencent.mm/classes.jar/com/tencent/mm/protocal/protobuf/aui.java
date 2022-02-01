package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aui
  extends cvc
{
  public LinkedList<String> Gss;
  public LinkedList<String> Gsy;
  public int Gsz;
  public String jdl;
  public String uhu;
  
  public aui()
  {
    AppMethodBeat.i(42638);
    this.Gsy = new LinkedList();
    this.Gss = new LinkedList();
    AppMethodBeat.o(42638);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42639);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.Gsy);
      paramVarArgs.e(3, 1, this.Gss);
      if (this.uhu != null) {
        paramVarArgs.d(4, this.uhu);
      }
      if (this.jdl != null) {
        paramVarArgs.d(5, this.jdl);
      }
      paramVarArgs.aS(6, this.Gsz);
      AppMethodBeat.o(42639);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.Gsy) + f.a.a.a.c(3, 1, this.Gss);
      paramInt = i;
      if (this.uhu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uhu);
      }
      i = paramInt;
      if (this.jdl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.jdl);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.Gsz);
      AppMethodBeat.o(42639);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gsy.clear();
        this.Gss.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(42639);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aui localaui = (aui)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42639);
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
            localaui.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42639);
          return 0;
        case 2: 
          localaui.Gsy.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(42639);
          return 0;
        case 3: 
          localaui.Gss.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(42639);
          return 0;
        case 4: 
          localaui.uhu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(42639);
          return 0;
        case 5: 
          localaui.jdl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(42639);
          return 0;
        }
        localaui.Gsz = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(42639);
        return 0;
      }
      AppMethodBeat.o(42639);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aui
 * JD-Core Version:    0.7.0.1
 */