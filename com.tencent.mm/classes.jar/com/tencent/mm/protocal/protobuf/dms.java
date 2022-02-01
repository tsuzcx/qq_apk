package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dms
  extends com.tencent.mm.bw.a
{
  public String Eww;
  public String Ewx;
  public String Ewy;
  public com.tencent.mm.bw.b FUu;
  public boolean FUv;
  public LinkedList<String> FUw;
  public String FUx;
  public String MD5;
  public int vTH;
  public int vTI;
  
  public dms()
  {
    AppMethodBeat.i(104839);
    this.FUw = new LinkedList();
    AppMethodBeat.o(104839);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104840);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FUu == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: EmojiBuffer");
        AppMethodBeat.o(104840);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.d(1, this.MD5);
      }
      paramVarArgs.aR(2, this.vTI);
      paramVarArgs.aR(3, this.vTH);
      if (this.FUu != null) {
        paramVarArgs.c(4, this.FUu);
      }
      paramVarArgs.bl(5, this.FUv);
      paramVarArgs.e(6, 1, this.FUw);
      if (this.Eww != null) {
        paramVarArgs.d(7, this.Eww);
      }
      if (this.FUx != null) {
        paramVarArgs.d(8, this.FUx);
      }
      if (this.Ewy != null) {
        paramVarArgs.d(9, this.Ewy);
      }
      if (this.Ewx != null) {
        paramVarArgs.d(10, this.Ewx);
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
      int i = paramInt + f.a.a.b.b.a.bx(2, this.vTI) + f.a.a.b.b.a.bx(3, this.vTH);
      paramInt = i;
      if (this.FUu != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.FUu);
      }
      i = paramInt + (f.a.a.b.b.a.fK(5) + 1) + f.a.a.a.c(6, 1, this.FUw);
      paramInt = i;
      if (this.Eww != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Eww);
      }
      i = paramInt;
      if (this.FUx != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FUx);
      }
      paramInt = i;
      if (this.Ewy != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Ewy);
      }
      i = paramInt;
      if (this.Ewx != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Ewx);
      }
      AppMethodBeat.o(104840);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FUw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FUu == null)
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
        dms localdms = (dms)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104840);
          return -1;
        case 1: 
          localdms.MD5 = locala.LVo.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 2: 
          localdms.vTI = locala.LVo.xF();
          AppMethodBeat.o(104840);
          return 0;
        case 3: 
          localdms.vTH = locala.LVo.xF();
          AppMethodBeat.o(104840);
          return 0;
        case 4: 
          localdms.FUu = locala.LVo.gfk();
          AppMethodBeat.o(104840);
          return 0;
        case 5: 
          localdms.FUv = locala.LVo.fZX();
          AppMethodBeat.o(104840);
          return 0;
        case 6: 
          localdms.FUw.add(locala.LVo.readString());
          AppMethodBeat.o(104840);
          return 0;
        case 7: 
          localdms.Eww = locala.LVo.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 8: 
          localdms.FUx = locala.LVo.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 9: 
          localdms.Ewy = locala.LVo.readString();
          AppMethodBeat.o(104840);
          return 0;
        }
        localdms.Ewx = locala.LVo.readString();
        AppMethodBeat.o(104840);
        return 0;
      }
      AppMethodBeat.o(104840);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dms
 * JD-Core Version:    0.7.0.1
 */