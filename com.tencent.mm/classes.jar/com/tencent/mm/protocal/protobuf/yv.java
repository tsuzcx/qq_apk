package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yv
  extends cvc
{
  public int FEY;
  public String FGE;
  public int FYt;
  public String FYu;
  public LinkedList<yu> FYv;
  public dbo FYw;
  public dcu FYx;
  public String Fvn;
  public int scene;
  
  public yv()
  {
    AppMethodBeat.i(124474);
    this.FYv = new LinkedList();
    AppMethodBeat.o(124474);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124475);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FYt);
      if (this.FYu != null) {
        paramVarArgs.d(3, this.FYu);
      }
      if (this.FGE != null) {
        paramVarArgs.d(4, this.FGE);
      }
      if (this.Fvn != null) {
        paramVarArgs.d(5, this.Fvn);
      }
      paramVarArgs.e(6, 8, this.FYv);
      paramVarArgs.aS(7, this.scene);
      paramVarArgs.aS(8, this.FEY);
      if (this.FYw != null)
      {
        paramVarArgs.lC(9, this.FYw.computeSize());
        this.FYw.writeFields(paramVarArgs);
      }
      if (this.FYx != null)
      {
        paramVarArgs.lC(10, this.FYx.computeSize());
        this.FYx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1078;
      }
    }
    label1078:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FYt);
      paramInt = i;
      if (this.FYu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FYu);
      }
      i = paramInt;
      if (this.FGE != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FGE);
      }
      paramInt = i;
      if (this.Fvn != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Fvn);
      }
      i = paramInt + f.a.a.a.c(6, 8, this.FYv) + f.a.a.b.b.a.bz(7, this.scene) + f.a.a.b.b.a.bz(8, this.FEY);
      paramInt = i;
      if (this.FYw != null) {
        paramInt = i + f.a.a.a.lB(9, this.FYw.computeSize());
      }
      i = paramInt;
      if (this.FYx != null) {
        i = paramInt + f.a.a.a.lB(10, this.FYx.computeSize());
      }
      AppMethodBeat.o(124475);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FYv.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yv localyv = (yv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124475);
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
            localyv.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        case 2: 
          localyv.FYt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124475);
          return 0;
        case 3: 
          localyv.FYu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 4: 
          localyv.FGE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 5: 
          localyv.Fvn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyv.FYv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        case 7: 
          localyv.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124475);
          return 0;
        case 8: 
          localyv.FEY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124475);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyv.FYw = ((dbo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dcu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dcu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyv.FYx = ((dcu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124475);
        return 0;
      }
      AppMethodBeat.o(124475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yv
 * JD-Core Version:    0.7.0.1
 */