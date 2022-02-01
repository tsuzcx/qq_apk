package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhf
  extends ckq
{
  public String Ddq;
  public String Ddr;
  public String Dds;
  public boolean Ext;
  public LinkedList<String> Exu;
  public String Exv;
  public boolean Exy;
  public String MD5;
  public int Scene;
  
  public dhf()
  {
    AppMethodBeat.i(104842);
    this.Exu = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(2, this.MD5);
      }
      paramVarArgs.bg(3, this.Exy);
      paramVarArgs.bg(4, this.Ext);
      paramVarArgs.e(5, 1, this.Exu);
      if (this.Ddq != null) {
        paramVarArgs.d(6, this.Ddq);
      }
      if (this.Exv != null) {
        paramVarArgs.d(7, this.Exv);
      }
      if (this.Dds != null) {
        paramVarArgs.d(8, this.Dds);
      }
      if (this.Ddr != null) {
        paramVarArgs.d(9, this.Ddr);
      }
      paramVarArgs.aR(10, this.Scene);
      AppMethodBeat.o(104843);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.MD5);
      }
      i = i + (f.a.a.b.b.a.fY(3) + 1) + (f.a.a.b.b.a.fY(4) + 1) + f.a.a.a.c(5, 1, this.Exu);
      paramInt = i;
      if (this.Ddq != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Ddq);
      }
      i = paramInt;
      if (this.Exv != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Exv);
      }
      paramInt = i;
      if (this.Dds != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Dds);
      }
      i = paramInt;
      if (this.Ddr != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Ddr);
      }
      paramInt = f.a.a.b.b.a.bA(10, this.Scene);
      AppMethodBeat.o(104843);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Exu.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(104843);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhf localdhf = (dhf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104843);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhf.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104843);
          return 0;
        case 2: 
          localdhf.MD5 = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 3: 
          localdhf.Exy = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(104843);
          return 0;
        case 4: 
          localdhf.Ext = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(104843);
          return 0;
        case 5: 
          localdhf.Exu.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(104843);
          return 0;
        case 6: 
          localdhf.Ddq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 7: 
          localdhf.Exv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 8: 
          localdhf.Dds = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 9: 
          localdhf.Ddr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104843);
          return 0;
        }
        localdhf.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(104843);
        return 0;
      }
      AppMethodBeat.o(104843);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhf
 * JD-Core Version:    0.7.0.1
 */