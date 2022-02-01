package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clx
  extends cvp
{
  public int FCq;
  public String FCr;
  public String FOY;
  public int Gzp;
  public LinkedList<ahk> Hfe;
  public LinkedList<az> Hff;
  public int Hfg;
  
  public clx()
  {
    AppMethodBeat.i(91628);
    this.Hfe = new LinkedList();
    this.Hff = new LinkedList();
    AppMethodBeat.o(91628);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91629);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Gzp);
      paramVarArgs.e(3, 8, this.Hfe);
      if (this.FOY != null) {
        paramVarArgs.d(4, this.FOY);
      }
      paramVarArgs.aS(5, this.FCq);
      if (this.FCr != null) {
        paramVarArgs.d(6, this.FCr);
      }
      paramVarArgs.e(7, 8, this.Hff);
      paramVarArgs.aS(8, this.Hfg);
      AppMethodBeat.o(91629);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label850;
      }
    }
    label850:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Gzp) + f.a.a.a.c(3, 8, this.Hfe);
      paramInt = i;
      if (this.FOY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FOY);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FCq);
      paramInt = i;
      if (this.FCr != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FCr);
      }
      i = f.a.a.a.c(7, 8, this.Hff);
      int j = f.a.a.b.b.a.bz(8, this.Hfg);
      AppMethodBeat.o(91629);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hfe.clear();
        this.Hff.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91629);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        clx localclx = (clx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91629);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localclx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        case 2: 
          localclx.Gzp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91629);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localclx.Hfe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        case 4: 
          localclx.FOY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91629);
          return 0;
        case 5: 
          localclx.FCq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91629);
          return 0;
        case 6: 
          localclx.FCr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91629);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new az();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((az)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localclx.Hff.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91629);
          return 0;
        }
        localclx.Hfg = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91629);
        return 0;
      }
      AppMethodBeat.o(91629);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clx
 * JD-Core Version:    0.7.0.1
 */