package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ane
  extends com.tencent.mm.bx.a
{
  public int CKO;
  public String Dap;
  public ann Don;
  public String Doo;
  public String IconUrl;
  public String Name;
  public String hnC;
  public String rZx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42632);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hnC == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.Dap == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.IconUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconUrl");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.Don == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadInfo");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.hnC != null) {
        paramVarArgs.d(1, this.hnC);
      }
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      if (this.Dap != null) {
        paramVarArgs.d(3, this.Dap);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(4, this.IconUrl);
      }
      if (this.rZx != null) {
        paramVarArgs.d(5, this.rZx);
      }
      if (this.Don != null)
      {
        paramVarArgs.kX(6, this.Don.computeSize());
        this.Don.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.CKO);
      if (this.Doo != null) {
        paramVarArgs.d(8, this.Doo);
      }
      AppMethodBeat.o(42632);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hnC == null) {
        break label962;
      }
    }
    label962:
    for (int i = f.a.a.b.b.a.e(1, this.hnC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Name);
      }
      i = paramInt;
      if (this.Dap != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Dap);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.IconUrl);
      }
      i = paramInt;
      if (this.rZx != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.rZx);
      }
      paramInt = i;
      if (this.Don != null) {
        paramInt = i + f.a.a.a.kW(6, this.Don.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.CKO);
      paramInt = i;
      if (this.Doo != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Doo);
      }
      AppMethodBeat.o(42632);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.hnC == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        if (this.Name == null)
        {
          paramVarArgs = new b("Not all required fields were included: Name");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        if (this.Dap == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        if (this.IconUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconUrl");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        if (this.Don == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadInfo");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42632);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ane localane = (ane)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42632);
          return -1;
        case 1: 
          localane.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 2: 
          localane.Name = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 3: 
          localane.Dap = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 4: 
          localane.IconUrl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 5: 
          localane.rZx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ann();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ann)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localane.Don = ((ann)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42632);
          return 0;
        case 7: 
          localane.CKO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(42632);
          return 0;
        }
        localane.Doo = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(42632);
        return 0;
      }
      AppMethodBeat.o(42632);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ane
 * JD-Core Version:    0.7.0.1
 */