package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhd
  extends com.tencent.mm.bx.a
{
  public String Ddq;
  public String Ddr;
  public String Dds;
  public com.tencent.mm.bx.b Exs;
  public boolean Ext;
  public LinkedList<String> Exu;
  public String Exv;
  public String MD5;
  public int uKQ;
  public int uKR;
  
  public dhd()
  {
    AppMethodBeat.i(104839);
    this.Exu = new LinkedList();
    AppMethodBeat.o(104839);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104840);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Exs == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: EmojiBuffer");
        AppMethodBeat.o(104840);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.d(1, this.MD5);
      }
      paramVarArgs.aR(2, this.uKR);
      paramVarArgs.aR(3, this.uKQ);
      if (this.Exs != null) {
        paramVarArgs.c(4, this.Exs);
      }
      paramVarArgs.bg(5, this.Ext);
      paramVarArgs.e(6, 1, this.Exu);
      if (this.Ddq != null) {
        paramVarArgs.d(7, this.Ddq);
      }
      if (this.Exv != null) {
        paramVarArgs.d(8, this.Exv);
      }
      if (this.Dds != null) {
        paramVarArgs.d(9, this.Dds);
      }
      if (this.Ddr != null) {
        paramVarArgs.d(10, this.Ddr);
      }
      AppMethodBeat.o(104840);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = f.a.a.b.b.a.e(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.uKR) + f.a.a.b.b.a.bA(3, this.uKQ);
      paramInt = i;
      if (this.Exs != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.Exs);
      }
      i = paramInt + (f.a.a.b.b.a.fY(5) + 1) + f.a.a.a.c(6, 1, this.Exu);
      paramInt = i;
      if (this.Ddq != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Ddq);
      }
      i = paramInt;
      if (this.Exv != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Exv);
      }
      paramInt = i;
      if (this.Dds != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Dds);
      }
      i = paramInt;
      if (this.Ddr != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Ddr);
      }
      AppMethodBeat.o(104840);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Exu.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Exs == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: EmojiBuffer");
          AppMethodBeat.o(104840);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104840);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dhd localdhd = (dhd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104840);
          return -1;
        case 1: 
          localdhd.MD5 = locala.KhF.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 2: 
          localdhd.uKR = locala.KhF.xS();
          AppMethodBeat.o(104840);
          return 0;
        case 3: 
          localdhd.uKQ = locala.KhF.xS();
          AppMethodBeat.o(104840);
          return 0;
        case 4: 
          localdhd.Exs = locala.KhF.fMu();
          AppMethodBeat.o(104840);
          return 0;
        case 5: 
          localdhd.Ext = locala.KhF.fHu();
          AppMethodBeat.o(104840);
          return 0;
        case 6: 
          localdhd.Exu.add(locala.KhF.readString());
          AppMethodBeat.o(104840);
          return 0;
        case 7: 
          localdhd.Ddq = locala.KhF.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 8: 
          localdhd.Exv = locala.KhF.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 9: 
          localdhd.Dds = locala.KhF.readString();
          AppMethodBeat.o(104840);
          return 0;
        }
        localdhd.Ddr = locala.KhF.readString();
        AppMethodBeat.o(104840);
        return 0;
      }
      AppMethodBeat.o(104840);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhd
 * JD-Core Version:    0.7.0.1
 */